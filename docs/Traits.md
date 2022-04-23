## Work in progress concept!
Not implemented yet, just design work!

Traits are effectively _injectable interfaces_.
- A (first party) type can implement a (third-party) trait directly.
- A (first party) trait can provide implementations for other (third-party) types.
- An instance of a (third-party) type can be tagged with a (first-party) implementation of a (third-party) trait.

For example,
```
// trait definition
trait Sized{
    int size();
    
    // implementation given by trait
    single StringSize implements Sized for String{
        int size(String self){
            return self.length();
        }
    }
}

// implementation given by inheritor
class MyList implements Sized{
    int size(){
        return ...;
    }
}

// implementation attached to instance
single ArrayListSize implements Sized for ArrayList<?>{
    int size(ArrayList<?> self){
        return self.size();
    }
}
...
Sized hasSize = new ArrayList() by ArrayListSize;
assert hasSize.getClass() == ArrayList.class; // the type is not wrapped in any way

// implemented by enum rather than single
enum MyEnum<class T> implements Sized for HashMap<T, ?>{
    val StringMapSize<String>{
        int size(HashMap<String, ?> self){
            return self.size();
        }
    };
    val IntMapSize<Integer>{
        int size(HashMap<Integer, ?> self){
            return self.size();
        }
    };
    val OtherMapSize<?>{
        int size(HashMap<?, ?> self){
            return self.size();
        }
    };
}
```

Bytecode-wise, usages of a trait are erased to Object, and `instanceof`/casts/method invocations use custom dynamic checks.
- If a type implements the trait, the instance is used as-is.
- Trait-provided implementations are stored in a `static WeakHashMap<Class<?>, [ThisTrait]>`.
- Instance tags are stored in a `static WeakHashMap<Object, [ThisTrait]>`.
- If an object matches none of these three criteria, an exception is thrown.

A third party implementation cannot be attached to a third-party type as a whole, to ensure that unexpected trait transmutations
do not occur in third-party code, subject to class loading order.

Storing the trait-provided implementations as a dynamic constant rather than a field may protect against using reflection to
add new implementations (at least, from Java).