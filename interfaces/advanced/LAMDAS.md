# Lambdas
Lambdas have become standard use across Java 8 and are found in many other languages. A lambda is a block of code 
that has no scope. It doesn't belong to any class and has *closure*. Closure simply means that anything inside the 
lambda cannot be accessed. Much like a method, if you create a variable inside the method, once the method exits, the
 variable is lost. 
 
## Anonymous Interfaces
Before I introduce the lambda syntax, let us look at a quick example. Imagine my `Bottle` class again, but this time 
I realized that not all bottles fill up the same way. Instead of extending for interfaces that fill differently, I 
could simply write some modifications.

```java
class Bottle implements Fillable {
	
	Fillable fillable;
	
	public Bottle(){
		this.fillable = null;
	}
	
	public Bottle(Fillable fillable){
		this.fillable = fillable;
	}
	
	public void fill(){
		if(this.fillable != null) this.fillable.fill();
		else System.out.println("Filled the bottle");
	}
}
```

This gives us something of the Open/Closed principle, yes? If I do not like the method used in filling, I can pass it
 my own. If you are thinking, wait, you cannot instantiate an interface, you are absolutely correct, but also wrong. 
 I can, just like `abstract` classes, create instances of them anonymously.
 
Lets do that quickly

```java
// Using original fill
Bottle bottle = new Bottle();
bottle.fill();

// Using an anonymous interface
Fillable fillable = new Fillable(){
	public void fill() {
		System.out.println("A dripping sink fills a bucket");
	}
};

Bottle betterBottle = new Bottle(fillable);
betterBottle.fill();
```

The syntax for an anonymous interface is interesting to say the least. We call `new Fillable()` just like you would 
any other time, but what is different is you have to also give the instance call the implementation of the required 
methods. Typically good IDEs will autofill the methods as per the signature for you, but if you have trouble 
remembering how it is supposed to look, just treat is as though you were writing a class. The first curly brace and 
last curly brace is the class scope.

## Lambdas, finally
Lets face it, anonymous intefaces are ugly. Now imagine if you didn't do the interface segregation principle and had 
30 or 40 methods to implement, you really would never enjoy writing those. Since you follow my patterns, lets look at
 an example of the `Bottle` implementation one more time.
 
```java
Bottle bottle = new Bottle(() -> System.out.println("What! This works? #lambdas"));
bottle.fill();
```

That's a *whole* lot cleaner, isn't it? Let's look at some of the syntax required to use lambdas and then some real 
world examples.

## Syntax
Java will do its best to infer what method should be used in a lambda. Since `Fillable` only has `fill`, its really 
easy to figure out. You do not provide the method name, nor the return type, nor the visibility. This is Java's job 
to figure out.

In fact, the lambda only consists of three parts, *Argument List*, *Arrow Token*, and *Body*

### Argument List
Next, we have the parameters. In the case of `fill`, it takes no parameters. This means we start our lambda with `()`
. Imagine for a second `fill()` looked like `fill(double amount)`. In that case we would use `(amount)`. Notice how I
 do not provide a type? That is also inferred.
 
### Arrow Token
Following the parameter list we have the *arrow token*, `->`. The arrow token links the parameters to the body 
implementation. Its more for visual effect than anything else.

### Body
Lastly, we have our simple `System.out.println()` statement. This is the body of our method. Notice how we didn't 
have any curly braces? They are not required for one line implementations. You could use them, but do not need to. 
One multiline implementations, they are mandatory.

```java
//legal - still one line
Bottle bottle new Bottle(() ->
	System.out.println("...");
);

//optional
Bottle bottle = new Bottle(() -> { System.out.println("..."); });

//optional 
Bottle bottle = new Bottle(() -> { 
	System.out.println("..."); 
});

// mandatory
Bottle bottle = new Bottle(() -> {
	System.out.println("...");
	System.out.println("....");
})
```

#### Returning from the body
Return statements are automatic if and only if you are in expression form (one liner).

Example

	() -> true;

If that was your implementation, it would return `true` always.

If you are in block form (curly braces), and you need to return a type, be it object or primitive, you have to use 
the traditional return statement.


## Methods that accept Lambdas
This is where the real power comes in to play. Imagine if you had a method that ran on dependencies. For example, if this, then do that, if that, then do this other thing, etc.  It could become a nightmare to handle that switching. What then happens when the switching has to be increased because a new condition arises? If we passed in an interace to solve that problem, we can focus on the main task at hand.

Example

```java
class ArrayList<E> {
	...
	...
	
	public void sort(Comparator comparator){
		// implementation snippet
		if(compare(this.get(i), this.get(i+1))){
			...
			...
		}
	}
	
	...
	...
}


Arraylist<String> list = new ArrayList<>();
list.add("dog");
list.add("cat");
list.add("hamster");

// sort ascending
list.sort((animal, other) -> animal.compareTo(other));

// sort descending
list.sort((animal, other) -> other.compareTo(animal));
```

Can you see how powerful that notion is? My `ArrayList` has no concept of how you wanted it sorted, but will accept an interface as a parameter and knock it out of the park. If we didn't use the interface passed, we would have to have something of the following:

```java
public void sort(String direction){
	// implementation snippet
	switch(direction.toLowerCase()){
		case "ascending": // do ascending
		case "descending": //do descending
	}
}

```
You can see how that is a nightmare. Now imagine if I wanted to sort by word length? With the previous example I would have to go in and modify the `sort` method, with lambdas, all I have to do is

	list.sort((animal, other) -> animal.length() - other.length());


## Conclusion
Do not be intimidated by lambdas. Once you accept how they work, they will speed your coding up tremendously.If you leverage the segregation principle, you will find lambdas completely natural.
