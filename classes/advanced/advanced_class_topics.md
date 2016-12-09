# Advanced Concepts in Classes

In this section I want to introduce you to the principles of declarative programming, Single use purpose, Open/Closed principle, DRY, immutable vs mutable objects, singleton classes. While we discussed some of them briefly in the introduction 
portion, we will re-evaluate them here as well.

## Declarative Programming
Being declarative is one of the most under utilized techniques a young engineer faces. Look at this example

    Dog dog = new Dog();
    dog.growl();
    dog.bark();
    dog.whimper();
  
Is there any confusion on what the dog is doing? Now look at how an young engineer may approach the same problem.

    Dog dog = new Dog();
    dog.setSound("growl");
    dog.getSound();
    dog.setSound("bark");
    dog.getSound();
    dog.setSound("whimper");
    dog.getSound();
    
Which code would you rather read 6 months after you wrote the `Dog` class? Sure, you may say "that is obvious!", but 
you know what, I will bet you have done something like this:

    String sound = "";
    Scanner scanner = new Scanner(System.in);
    System.out.println("What sound do you want the dog to make?");
    sound = scanner.nextLine();
    
Instead of doing the now-so-ever obvious:

    String sound = askTheUserForDogSound();
    
Again, after not looking at the code for 6 months, which would you rather read? Now that you get it, lets be formal. 
Declarative Programming is using methods that have logical, single purpose, names to fulfill your imperative logic. 
Create them, use them.

### Declarative Code Example
Let's run with the declarative dog example for a bit.

```java
package classes.advanced;

public class Dog {
	public void bark(){}
	public void growl(){}
	public void whimper(){}
}
```

Imagine we wanted to speakers on the computer to make those sounds. How can we do it? Lets look. Java has a class 
named `java.awt.Toolkit` that allows us to *beep* the computer with the `beep` method. We will say 3 beeps are a 
bark, 2 beeps are a growl, and 1 beep is a whimper.

```java
package classes.advanced;

import java.awt.Toolkit;

public class Dog {
	public void bark(){
		for(int i = 0; i < 3; i++)
	        Toolkit.getDefaultToolkit().beep();
	}
	public void growl(){
		for(int i = 0; i < 2; i++)
            Toolkit.getDefaultToolkit().beep();
	}
	public void whimper(){
		Toolkit.getDefaultToolkit().beep();
	}
}
```

This will work, but what principle are we violating here? Hopefully you see it is the DRY principle. So let's kill 
two birds with one stone and refactor our code with a private helper method.


```java
package classes.advanced;

import java.awt.Toolkit;

public class Dog {
	public void bark(){
		this._makeBeeps(3);
	}
	public void growl(){
		this._makeBeeps(2);
	}
	public void whimper(){
		this._makeBeeps(1);
	}
	
	private void _makeBeeps(int quantity){
		for(int i = 0; i < quantity; i++)
            Toolkit.getDefaultToolkit().beep();
	}
}
```
See how we do not repeat ourselves (DRY) and we are also declarative at the same time? This is how you want to 
develop your source code.


## Single Use Purpose
Single Use Purpose is just that, your code has a single purse. This means your method has a single purpose, your 
class has a single purpose, etc. Let us revisit our `askUserForDogSound` example by adding that method into `Dog`.

```java
public String askUserForDogSound(){
	Scanner scanner = new Scanner(System.in);
	System.out.println("What sound should the dog make?");
	String sound = scanner.nextLine();
	switch(sound){
		case "bark": this.bark(); break;
		case "growl": this.growl(); break;
		case "whimper": this.whimper();
	}
}
```

Ok, now what is the problem with this code's style? Hopefully since we are in Singe Use Purpose you see what it is 
immediately. We should not be calling `bark`, `growl`, nor `whimper`. What may not be obvious is that we shouldn't be
 asking the user at all in this class. The class is `Dog` correct? A dog doesn't ask what sound it should make. This 
 means we need to break things apart into proper classes and remove that method from `Dog` completely.
 
```java
package classes.advanced;

import java.util.Scanner;

public class DogInteraction {
	
	private final Dog dog = new Dog();
	
	public String askUserForDogSound(){
		Scanner scanner = new Scanner(System.in);
        System.out.println("What sound should the dog make?");
        return scanner.nextLine();
	}
	
	public DogInteraction commandDogTo(String action){
		switch(action){
			case "bark": this.dog.bark(); break;
            case "growl": this.dog.growl(); break;
            case "whimper": this.dog.whimper();
		}
		return this;
	}
}
```

Now we can add a `main` method for testing purposes. This can be either a one-off driver class or simply the `main` 
method to `DogInteraction`. I will assume the latter.

```java
public static void main(String[] args){
	DogInteraction di = new DogInteraction();
	if(args.length){
	    di.commandDogTo(args[0]);
	} else {
		di.askUserForDogSound();
	}
	
}
```
It may cost more code now to make something single purpose, but in the long run, especially when writing complex 
applications, it pay in more than just dividends. In fact, when you submit code for a sample when interviewing, 
Single Use Purpose code will probably land you the job with a higher starting pay. 

## Open/Closed Principle

Taking straight from [wikipedia](https://en.wikipedia.org/wiki/Open/closed_principle), "In object-oriented programming, the open/closed principle states "software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source code."

This will make much more sense when we get into inheritance, but what it means is that our source is open to be 
extended, but closed to modification. This means, as soon as we publish it, we should not be changing its core 
features so that we can "make it better", but rather extend it to make it better. A quick example without source code.

Imagine we had a class `Rectangle` that was a POJO and only had `width` and `height`. If we wanted to create a tool 
to calculate its area, we could simply write a calculator to compute `width * height`. Now if we later decided to add
 more shapes, we could always go back to the calculator to add more logic to handle the different shapes. Wrong! This
  is bad. Instead, the better approach would be to create an `abstract` class named `Shape` that had an `abstract` 
  method `getArea` that forced anyone extending the class to provide the functionality to compute area. Now, in our 
  calculator, we can call the `Shapes` method via polymorphism, falling back to the implementation of shape in the 
  child class. With this approach, the calculator is *closed* to modification but `Shape` is open to extension.
  
When designing your classes, adhere to this principle.

## DRY - DONT REPEAT YOURSELF
Lets face it, this one is easy to do. No one likes writing the same code over and over again. So dont. Oh yeah, do 
not copy paste either. Just write a single purpose helper method, usually private, to absorb the repetition.

## Immutable vs Mutable Objects

I do not like mutable objects. Unfortunately sometimes we have to use them. But let us try not to. What is a mutable 
object, well, if you have mutators (setters) it is mutable. Example:

```java
package classes.advanced;

public class MutatblePOJO {
	private int num;
	public void setNum(int num){ this.num = num; }
	public int getNum(){ return this.num; }
}
```

Why is this bad? Well. To be honest, it not always bad. But you will face situations more often than not in 
enterprise settings where `num` can be set by another object without you knowing it followed by you setting it. That 
mutation, rather the setting of the variable, is known as a *side effect*. If I can reduce side effects to only 
occurring in a single case, then I will run into a whole lot less hard to trace runtime bugs. 

Ok, you're sold? Good. Now how do we create an immutable object? Easy.

```java
package classes.advanced;

public class ImmutatblePOJO {
	private final int num;
	
	public ImmutablePOJO(int num){
		this.num = num;
	}
	
	public int getNum(){ return this.num; }
}
```

By using the keyword `final` in the declaration of the POJO, I prevent it from ever changing after it has been 
created. Of course, during the time of construction the member variable hasn't been created, so I can set it there. 
But once I exit the constructor, that `num` is as `num` is until the garbage collector picks it up.

## Singleton Classes
Singleton classes are class that only need one instance. In many ways this is like a `static` inner class, but since 
you cannot create static top level classes, we will can do singletons. 

The basic idea behind this is that you will call for an `instance` of the class. If that instance does *not* exist, 
you will create that one and return it. If it does exist, then you will return it only. But wait, how does a class 
create itself? Good question. We will use a `static` method. A `static` method named `getInstance` will be available via 
the class 
(not 
an instance) and it will return us the instance of the class. Lets look at the code.

```java
package classes.advanced;

public class Singleton {
   private static Singleton instance = null;
   private int num = 0;
   
   private Singleton() {}
   
   public static Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
      }
      return instance;
   }
   
   public int getNum(){ return this.num; }
   public void incrementNum(){ this.num++; }
}
```

Now with this code, if we wanted to use the singleton, we have to do the following:

    Singleton s = Singleton.getInstance();
    System.out.println(s.getNum());
    
But what is cool about this, is that since there will only ever be one instance, we can have multiple variables work 
on it.

    Singleton a = Singleton.getInstance();
    Singleton b = Singleton.getInstance(); 
    a.increment();
    System.out.println(b.getNum();