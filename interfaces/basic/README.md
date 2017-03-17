# Basic Interfaces
Interfaces are like `abstract` classes but only allow for method signatures. To construct an interface, instead of 
the keyword `class` we use the keyword `interface`.

Example:

```java
interface Fillable {
	
}
```

Standard practice tells us to name the interface as an `able` type, such as `Fillable` or `Pourable`. Another 
standard practice you will see is the interface named as `FillInterface` or `PourInterface`. But since we are only 
going to describe actions and eventually use the *interface segregation principle*, so naming them as adjectives 
makes the most sense.
 
## Interface Restrictions
Interfaces have no properties. They only have method *signatures*. This means unlike a class you inherit in which you
 can create a method body, you cannot do this with interfaces. A method signature is simply the return type, the 
 method name, parameters, and if needed, thrown exceptions.
 
 ```java
interface Fillable {
	void fill();
}
```

You do not need to set a visibility modifier to an interface or its method. They are all `public`. I am not sure if 
older versions of java behaved differently, but for java 8 and beyond, this is the case.

## Using Interfaces
Interfaces are simple to use. 


```java
class Bottle implements Pourable {
	public void pour(){
		// do pour
	}
}
```

Instead of using the keyword `extend` you use `implements`. Unlike inheritance you have learned so far, you can 
implement as many interfaces as you wish.

```java
class Bottle implements Pourable, Fillable {
	public void pour(){
		//do pour
	}
	
	public void fill(){
		// do fill
	}
}
```

## Interface Polymorphism
In the case of `Bottle`, it *is-a* `Pourable` as well as it *is-a* `Fillable`. This means we can polymorph into either.

	Pourable bottle = new Bottle();
	Fillable anotherBottle = new Bottle();
	
Both the following are legal, but as with polymorphism across the inheritance chain, only the interface type methods 
are available. This means the following works.

```java
class Rain implements Pourable {
	public void pour(){
		//do pouring
	}
}

ArrayList<Pourable> list = new ArrayList<>();
list.add(new Bottle());
list.add(new Rain());

list.stream.forEach((bottle) -> {
	bottle.pour();
});
```

What even cool is that since Java will try to resolve any casts, you can do the following as well:

```java
Bottle bottle = new Bottle();
Pourable asPourable = (Pourable) bottle;
Fillable asFillable = (Fillabe) bottle;
```

## Using Interfaces with Inheritance
While implementing interfaces are loosely a form of inheritance, we can still use the keyword `extend` in our classes.

```java
class Bottle extends Container implements Pourable, Fillable {
	...
	...
	...
}
```

Now a `Bottle` *is-a* `Container`, a `Pourable`, and a `Fillable`.

## Interface Segregation Principle
The idea behind this principle is so the user of your class doesn't have to use methods of the class that is not 
useful to them. Imagine our `Bottle` example. If they are writing a manufacturing class that only fills a bottle, 
then having `pour` build in to the class is rather useless. By *segregating* actions into smaller and smaller chunks,
 we can not only polymorph into objects that need to be filled, but we can also easily manage inheritance so that we 
 do not have issues scaling our source and having inheritance collisions.
 
 Because of this, my preference is name an interface as an adjective and provide the verb as the method. This means 
 that for most cases, my interfaces have one method signature. Later when we get into lambdas, you will see why this 
 is a good idea.
 
 
