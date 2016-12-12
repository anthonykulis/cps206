# Generic Classes
You will encounter generic classes in Java. It is guaranteed. A generic class is a class that works on a given object of unknown type. When you encounter one of these classes, realize it means it can work on the data type you want, if 
and only if your data type fits within it defined bounds.

An example of this is a class that will sort your collection of objects (probably most common). I ask, how do you 
sort a collection of `Rectangle`? By area? Maybe. What if I wanted to sort by height? Or width? Now imagine I wanted 
to have a collection of `String`. How to sort this is easy. We sort alphabetically. In fact, that is so common, 
`String` implements the interface `Comparable`. But `Rectangle`? Let's explore this with code.

## Generic Notation
You may see a class named `MyClass<E>`. The `<>` means this class is generic, meaning it works on a given object 
without knowing ahead of time what that object is. Kind of cool really. The `E` is the *placeholder* for that object 
while in the class. Think of it as variable for the data type, not the variable of the data type. This means in `String 
dog`, `dog` is **not** `E`, but if we passed `String` to `MyClass`, `E` would be `String`.

So to instantiate `MyClass<E>` with the type `String`, we need to do the following:

```java
MyClass<String> myClass = new MyClass<>();
```

Let's break this down.

### Declaration of Generic Classes
In the declaration, `MyClass<String> myClass`, along with declaring the variable `myClass` of type `MyClass<E>`, we 
*declare* the type `E` as `String`. Now, and for all times, this **instance** of the class belonging to `myClass` 
will treat `E` as a `String`.

In the instantiation part, `new MyClass<>()`, we add the `<>` in-between the class name and the parenthesis. We do 
not, *in java 7 and beyond* need to use the declared type `String`. 
 
## Bounded Types
So far we have seen very easy usage of generics. But what happens with our `String` and `Rectangle` examples if we 
put them into a collection that sorts? Lets use [ArrayList](http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). This collection allows us to sort the entries.  If you scroll down to the methods, you will see [sort](
Writing objects: 100% (6/6), 572 bytes | 0 bytes/s, done.
). It has the following signature:

```java
public void sort(Comparator<? super E> c);
```

From what we already know, the sort method takes an generic `Comparator` with a type `E`. But all that extra syntax, 
it is a bound. In this case it is a *lower bound*. Seeing we have a lower bound, this implies we also have an *upper 
bound*. The following is the notation for those with a brief explanation. As we learn more about OOP these 
explanations will make more sense.

### Lower Bound
In OOP we can *inherit* features from an object. This lower bound simply says the generic will accept any class `E` 
and it's super classes. If another class extended whatever `E` was, it would not be able to use this method when the 
`ArrayList` is set to the type of `E`

For example, using our `Rectangle`, we could extend that to `Square`. If we set up our list as 

    ArrayList<Rectangle> list;
    
We could not use the sort method if we passed `list.add(new Square())` even though a `Square` is-a `Rectangle`. You 
can think of this as a way of "limiting access" by making it more restrictive. And this makes sense! If we wanted to 
sort by height, and a square has no "height" or "width", only a "side", how can we sort it by height? Logically we 
know that the height is equal to the width, so side is either one of the two, but the computer doesn't know that. So 
lets think about this a bit different with upper bounds.

### Upper Bound
The opposite of a lower bound is an upper bound. Imagine with our `Rectangle` example we created a class that can now
 sort any rectangle, even a square, but it can only sort these four sided things. We could set an upper bound.
 
```java
class OurImprovedRectangleSorter<E extends Rectangle>{}
```

Now with the `<E extends Rectangle>`, we are saying we accept any `E` *as long as it *is-a* Rectangle`*, and hence,
 we can now "sort" squares.
 
## Conclusion
So when you encounter a generic class with type `<E>`, or similar, you can use it on any object. When you encounter 
`<? super E>`, you can only use classes `E` and up the inheritance chain. And when you encounter `<E extends 
SomeClass>`, you can only use `SomeClass` and its descendants.