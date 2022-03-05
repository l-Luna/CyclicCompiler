package cyclic.lang.compiler.resolve;

import cyclic.lang.compiler.model.CallableReference;
import cyclic.lang.compiler.model.MethodReference;
import cyclic.lang.compiler.model.TypeReference;
import cyclic.lang.compiler.model.instructions.Value;
import cyclic.lang.compiler.model.platform.ArrayTypeRef;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class MethodResolver{
	
	private record Target<T extends CallableReference>(T ref, boolean isLoose, boolean isVarargs){}
	
	private static final Comparator<Target<?>> BASE_COMPARATOR = Comparator.<Target<?>, Boolean>
					comparing(Target::isLoose).thenComparing(Target::isVarargs);
	
	private static final Comparator<Target<?>> BY_PARAMETERS =
			(left, right) -> moreSpecific(left, right) ? 1 : moreSpecific(right, left) ? -1 : 0;
	
	public static final Comparator<Target<?>> BY_RETURN_TYPE =
			(left, right) -> {
				if(left.ref() instanceof MethodReference)
					return moreSpecificReturn(left, right) ? 1 : moreSpecificReturn(right, left) ? -1 : 0;
				return 0;
			};
	
	public static <T extends CallableReference> @Nullable T best(List<T> candidates, List<Value> args){
		List<Target<T>> targets = new ArrayList<>();
		
		candidates: // continue this when an invalid argument is found
		for(T candidate : candidates){
			List<TypeReference> parameters = candidate.parameters();
			
			varargs: // break this when an invalid argument is found
			if(candidate.isVarargs() && args.size() >= parameters.size() - 1){
				boolean loose = false;
				for(int i = 0; i < args.size(); i++){
					Value arg = args.get(i);
					TypeReference checking;
					if(i + 1 < parameters.size())
						checking = parameters.get(i);
					else{
						checking = parameters.get(parameters.size() - 1);
						if(checking instanceof ArrayTypeRef arr)
							checking = arr.getComponent();
						else
							break varargs; // invalid varargs method
					}
					if(arg.type() == null || !arg.type().isAssignableTo(checking))
						if(arg.fit(checking) != null)
							loose = true;
						else
							break varargs;
				}
				targets.add(new Target<>(candidate, loose, true));
			}
			
			if(candidate.parameters().size() != args.size())
				continue;
			boolean loose = false;
			for(int i = 0; i < parameters.size(); i++){
				TypeReference checking = parameters.get(i);
				Value arg = args.get(i);
				if(arg.type() == null || !arg.type().isAssignableTo(checking))
					if(arg.fit(checking) != null)
						loose = true;
					else
						continue candidates;
			}
			targets.add(new Target<>(candidate, loose, false));
		}
		
		if(targets.size() == 0)
			return null;
		targets.sort(BASE_COMPARATOR);
		var best = targets.get(0);
		var bests = targets.stream()
				.takeWhile(x -> x.isLoose() == best.isLoose()
							&& x.isVarargs() == best.isVarargs())
				.toList();
		if(bests.size() == 1)
			return bests.get(0).ref();
		
		// TODO: throw error on ambiguity
		return bests.stream()
				.max(BY_PARAMETERS.thenComparing(BY_RETURN_TYPE))
				.orElseThrow()
				.ref();
	}
	
	private static boolean moreSpecific(Target<?> left, Target<?> right){
		// if every type is more specific only
		List<TypeReference> parameters = left.ref().parameters();
		for(int i = 0; i < parameters.size(); i++){
			var lp = parameters.get(i);
			var rp = right.ref().parameters().get(i);
			if(!moreSpecificType(lp, rp))
				return false;
		}
		return true;
	}
	
	private static boolean moreSpecificType(TypeReference self, TypeReference other){
		return !other.isAssignableTo(self) && self.isAssignableTo(other);
	}
	
	private static boolean moreSpecificReturn(Target<?> left, Target<?> right){
		return moreSpecificType(((MethodReference)left.ref()).returns(), ((MethodReference)right.ref()).returns());
	}
}