# Cyclic
Cyclic is a general-purpose JVM programming language, with a syntax based on Java, focused on explicitness and conciseness.

## Syntax
A basic file might look pretty familiar:
```cyclic
package example;

class Example{
  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }
}
```

We have some new things though:
```cyclic
package sample;

import java.util.Random;

static single Magic8Ball {

    final Random random = new Random();

    enum Answer {
        val YES("yes");
        val NO("no");
        val MAYBE("maybe");
        val DONT_KNOW("don't know");

        String text;
        Answer(String text) -> this.text = text;

        static Answer random() {
            return (Answer) Magic8Ball.random.nextInt(entries().size()) |> entries().get();
        }
    }

    public void main(String[] args) {
        var idea = args[0];
        Answer response = Answer.random();
        System.out.println("\"" + idea + "\"? 8 ball says: " + response.name().toLowerCase());
    }
}
```

In particular:
- `single` types are singletons: only one instance exists, implicitly, accessed by the type's name.
- `static single`s have implicitly static members, acting as simple code holders.
```cyclic
single Magic8Ball {
    public static void main(String[] args) {
        System.out.println("I'm a " + Magic8Ball + "!");
    }
}
```
- Methods and constructors that only have one statement or return one value can use a lambda-like syntax.
```cyclic
class Answer {
    String text;
    
    public Answer(String text) -> this.text = text;
    String getText() -> text;
    void throwOnBadText() ->
        if(text == null)
            throw new IllegalArgumentException("No text given!");
}
```
- `|>` is the "pass" operator, which passes the left-hand side as the first argument to call on the right-hand side. This makes chaining calls more readable.
```cyclic
val data = args[0]
    |> Integer.parseInt()
    |> Math.abs()
    |> Math.sqrt()
    |> Math.round()
    |> Integer.toString();
```
- Enums use a `val` syntax to define their entries, which can appear in any order relative to other members. They define an implicit `entries()` method, returning an immutable list of enum entries. Finally, they can be iterated through in a for-each loop.
```cyclic
enum Answer{
    String text;
    Answer(String text) -> this.text = text;
    
    val YES("yes");
    val NO("no");
    val MAYBE();
    val DONT_KNOW;
    val ONE_DAY("one day");
    
    Answer() -> this("idk");

    static Answer byName(String name) {
        for(Answer answer : Answer) {
            if(answer.name().equals(name))
                return answer;
        }
        return null;
    }
    
    static int choices() -> Answer.entries().size();
}
```
- Interface methods with a block or arrow are implicitly `default` methods.
```cyclic
interface CoolInterface {
    void imAbstract();
    
    void doSomething(){
        System.out.println("I'm cool!");
    }
    int returnSomething() -> 42;
}
```
- Annotations are defined using more standard syntax. Their methods can have blocks, so long as they only return a value, or override a method from an interface specially marked as `@AnnotationsCanImplement`.
```cyclic
package cyclic.lang.annotations;

import cyclic.lang.*;

public annotation Nonnull implements CheckerAnnotation{

    String value();
    String message() -> "Value must not be null.";
    
    public void check(Object param){
        if(param == null)
            throw new NullPointerException(reason());
    }
}
```
Note that checker annotations are not yet checked - the syntax and mechanics will change in future versions.

## Future improvements
There's still a lot missing, and many improvements left to be made to what already exists.

### Regular code
A few regular statements and expressions are missing, like `switch`s, labelled `break`s/`continue`s, `do { ...yield ...;}` expressions, and ternary operators.  
All but the last require some more design work:
- `switch`s should follow modern pattern-y exhaustive-y designs, but those rely on features still a ways away.
- Labels are useless in most cases; I'd like to make them more widely useful, perhaps allowing you to `do` a labelled statement later in a method.

### Type system
Generics are the next main feature, and alongside them, I'd like to introduce other features to make types more flexible:
- `type` definition statements, which would allow naming a given type.
```
type MyString = String;
type MyList<T> = List<T>;
type StringList = MyList<String>;
```
- Allowing the use of intersection and union types in type definitions. These already exist in Java, but only in specific contexts.
```
type Element = Leaf | Node;
type MatchErrors = NullPointerException | IncompatibleClassChangeError;
type SerializableFunction<T, R> = Function<T, R> & Serializable;
```
- Defining methods with the type `this!`, with subtypes returning their exact type, avoiding the `Foo<F extends Foo>` dance. (Should `this!` be usable as a type in other contexts?)
```
class CoolCollection<T> {
    this! mapButCool(Function<T, T> f) -> ...;
}
class CoolList<T> extends CoolCollection<T> {
    ...
}
CoolList<String> coolList = new CoolList<String>();
coolList = coolList.mapButCool(String::toUpperCase); // exact type is kept
```
- Defining generics with `in` or `out` to specify co/contravariance at the definition, rather than every use.
```cyclic
interface CoolFunction<in T, out R> {
    R apply(T t);
}
```
- Reifiable generics, which allow operations like `instanceof T`, `new T[]`, and `T.class`, defined with `<class T>`.

```cyclic
import java.util.*;
class CoolList<class T> extends List<T> {
    T[] array = new T[0];

    void addIfRightType(Object o) {
        if(o instanceof T){
            array = Arrays.copyOf(array, array.length + 1);
            array[array.length - 1] = (T)o;
        }
    }
}
```
- `abstract static` methods in interfaces.
```
interface Numeric<T> {
    abstract static T zero();
    abstract static T add(T a, T b);
}
...
public <class T> T double(T x) {
    return T.add(x, x);
}
```

### Checkers
Static type checking is useful, but custom static checking would allow for more extensive and application-specific checks. These will be done by checkers, a form of annotation:
```
annotation Valid extends Checker<Element>{
    public void check(Element entry){
        if(entry.source == null)
            throw new IllegalStateException("Element has no source.");
    }
}
...
void deleteElement(#Valid Element e){
    entry.source.delete();
}
...
#Valid Element e = ...;
deleteElement(e); // OK
deleteElement(new Element()); // IllegalStateException
Element ok = new Element(new Source(...));
deleteElement((#Valid _)ok); // OK
```
The compiler assumes that check conditions can only be modified by specific operations, and otherwise allows a value that is known correct (via runtime checks or static evaluation) to be passed around.
- How should invalidation operations be defined?
- What level of static evaluation should the compiler perform? `new X()` is obviously non-null, but is `new X().foo()` null? How can guarantees on external code be inferred or specified?

### Metaprogramming
A simple form of metaprogramming could be built upon the existing reflection and invocation APIs, like so:
```
void generated()
    by MyLinker::link;
...
class MyLinker {
    static MethodHandle link(Method from) {
        ...
    }
}
```
This is a pretty raw API still, only slightly tamer than `invokedynamic`; but does allow for runtime codegen, using Panama APIs, and can be used as a basis for more convenient APIs.
- Could delegation between linked be given a more explicit form?
- Could a different outline provide better opportunities for static analysis?
- Could the use of a raw `MethodHandle` be avoided and replaced with something more convenient?

### Values as methods/members
In Java, functional interfaces represent methods and getters. Invoking these can be verbose compared to languages with actual function values - `x.apply(y)` compared to `x(y)` - but keeps the value-ness explicit.
I'd like to provide shorthand for performing the "obvious action" of an object:
```
Function<...> uppercase = String::toUpperCase;
val shout = uppercase!("hi");

Supplier<Object> property = () -> null;
val it = property!;
```
- Should non-FIs be able to define an obvious action? By what syntax?
