# Polymorphism

Polymorphism is a powerful OOP pillar that allows one object to become another object if, and only if, it belongs in 
its inheritance tree. This is useful for supplying methods to a user when you do not know what object they will use, 
or as a user to call upon a method of another class using a child class of the required type. 

## Polymorphism in use

Imagine the following class 

```java
package oop_pillars.polymorphism;

class ParentClass {
	void sayHello(){ System.out.println("Hello"); }
	String toString(){ return "parent"; }
}
```

```java
package oop_pillars.polymorphism;

interface SomeInterface {
	public void doSomething();
}
```

```java
package oop_pillars.polymorphism;

class ChildClass extends ParentClass implements SomeInterface {
	
	void childMethod();
	
	// overrides doSomething
	public void doSomething(){
		//do something for the child
	}
	
	// overrides toString
	String toString(){ return "child; "; }
}
```

`ChildClass` here *is-a* `ParentClass`. It also *is-a* `SomeInterface` class. 
This means all the following is legal.

    ChildClass<String> child = new ChildClass<>();
    
    ParentClass p = child;
    SomeInterface si = child;
    
While you may ask why, we need to explain more. 

### Polymorphing into parent

When we polymorph into another *is-a* object, we take on the properties and methods of that object and *lose* our class methods and properties, sort of. Java will actually try to resolve the most likely belonging method. So when we polymorph into `ParentClass`, we lose `doSomething` because it doesn't belong to the parent, but interestingly, we do not lose our childs `toString` and use the parents, we use our own. You can try this if you do not believe me.
 
When we polymorph into `SomeInterface`, we lose `sayHello` and keep `doSomething` because `doSomething` belongs to 
the interace. Interestingly, because the interface inherits from `Object`, and `Object` has `toString`, we keep our 
`toString` method.

## Restricting access with polymorphism.

Now imagine we have a class that has a method which internally uses a passed objects `doSomething` method. See the 
following code for an example.

```java
class DoesSomethingSpecial {
	public void doIt(ChildClass c){
		c.doSomething();
	}
}
```

We can use this classes `doIT` method passing an instace of `ChildClass`. Because we knew ahead of time that 
`ChildClass` implements `SomeInterface`, we get away with it. But what happens when I create another class.

```java
class AnotherClass extends ParentClass implements SomeInterface {
	void anotherMethod(){}
	public void doSomething(){
		// do something for another
	}
	public String toString(){ return "another class"; }
}
```

This class and `ChildClass` are very similar except in their core methods (`anotherMethod` and `childMethod`). This 
is what we want in OOP. They both inherit `sayHello` from abstraction, they both implement their own versions of 
`doSomething`, and they both override `toString`. But we want to be able to use `DoesSomethingSpecial` for both 
classes. This means, without polymorphism, we would be stuck overloading the `doIt` method for each data type that 
implements `doSomething`. But since we have polymorphism, lets just update the code to its correct state.

```java
class DoesSomethingSpecial {
	public void doIt(SomeInterface si){
		si.doSomething();
		
		// while we are at it, try this
		System.out.println(si);
	}
}
```

Now when we add functionality to a main method somewhere, we get polymorphism in action

    ChildClass c = new ChildClass();
    AnotherClass a = new AnotherClass();
    DoesSomethingSpecial d = new DoesSomethingSpecial();
    d.doIt(c);
    d.doIt(a);
    
Try it out.