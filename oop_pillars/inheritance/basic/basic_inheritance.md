# Basic Inheritance
Following the principle of [abstraction](/oop_pillars/abstraction) we get the next principle of *inheritance*. They go hand in hand. Since the idea of abstraction is *remove* common methods and properties from like classes and put 
them into a parent class, then it makes sense that the child classes can inherit those properties. This is no 
different in concept than how you inherit properties from your parents, them from their parents, and so on. Over time, you
 have inherited the properties of many generations before you. This is what OOP strives to do. It has its problems 
 though.
 
## Sharing like properties/methods
 
Let us imagine two classes, `dog` and `cat`, the same ones used in the the abstraction example. 

```java
class Cat {
	String sex;
	String breed;
	void run(){}
	void meow(){}
}

class Dog {
	String sex;
	String breed;
	void run(){}
	void bark(){}
}
```

If we imagine a Venn diagram of these two classes we will see `sex`, `breed`, and `run` overlap. We now abstract 
those out into `Animal`

```java
class Animal {
	String sex;
	String breed;
	void run(){}
}
```

Now our `Cat` and `Dog` can both *inherit those properties and methods with the keyword `extends`.

```java
class Cat extends Animal {
	void meow(){}
}

class Dog extends Animal {
	void bark(){}
}
```

This is good. Now when we instantiate `Cat` or `Dog`, we will get them methods and properties from `Animal`.

	Dog dog = new Dog();
	dog.sex = "male";
	dog.breed = "mutt";
	dog.run();
	dog.bark();
	
	Cat cat = new Cat();
	cat.sex = "female";
	cat.breed = "cats have breeds?";
	cat.run();
	cat.meow();
	
Even though we didnt formally declare `sex`, `breed`, and `run`, from inheritance each of our child classes have 
those methods. The only limitation to inheritance is that you can *only* inherit from one parent. And because of 
this, we can now introduce what I like to call *INHERITANCE NIGHTMARES* --- ooooh. scary.

### Inheritance Nightmares

But do you see an issue yet? I hinted to it with cats when I assigned the breed. I know cats have breeds, but how 
about sparrows? Does a sparrow have breed? No. Is it an animal? Yes. So something has to give. It looks like we named
 our parent class incorrectly. Let us rename it to `DomesticAnimal`.
 
```java
class DomesticAnimal {
	String sex;
    String breed;
    void run(){}
}
```

And inherit from that with `Cat` and `Dog`.

```java
class Cat extends DomesticAnimal {}

class Dog extends DomesticAnimal {}
```

Ok that is better. I believe domestic animals have a `breed`. What about `sex` though. All animals have a sex. Do all
 animals run? A snake doesn't run. It is an animal. So we cannot move that to animal. But non-domestic animals do run.
  So that has to give too. Lets first handle `sex`.
  
```java
class Animal {
	String sex;
}
```

Now `DomesticAnimal` can inherit `Animal`

```java
class DomesticAnimal extends Animal {
	String breed;
	void run();
}
```

Before we dive into the `run` issue, lets look at our inheritance chain so far.

	Animal -> DomesticAnimal -> {Cat, Dog}
	
Ok. Lets add a `Snake` to the mix. Lets also assume only right minded people exist in this world and none of them 
keep snakes for pets. This is just for the sake of example! Please no emails.

```java
class Snake extends Animal {
	
}
```

Clearly a snake is an animal, so it should inherit from there. So let us now think about our `run` method. There are 
other non-domestic animals that still run, such as Bears. Lets create a `Bear`.

```java
class Bear extends Animal {
}
```

Bear extends from Animal, but it needs to run. Do I reimplement run? No. That would violate so many principles of OOP
. It means we need to inherit better. I cannot extend `DomesticAnimal` because unless your are insane, you do not 
keep a bear as a pet, but run needs to be available to us somewhere. Well, if we think about it, maybe we should move
 `Bear` to inherit from `WildAnimal` instead. Maybe the logical place to run will reveal itself. 
 
```java
class WildAnimal extends Animal {
	
}

class Bear extends WildAnimal {
	
}
```

Ok, this is making more sense now. These are logical inheritance patterns. But we still know not all Animals have 4 
legs, some have 2, some have none. Those with none cannot run. So we should create another class named `LeggedAnimal`
 that inherits animal, has the method `run`, and domestic and wild animals inherit from it.
 
```java
class LeggedAnimal extends Animal {
	void run();
}

class DomesticAnimal extends LeggedAnimal {
	
}

class Cat extends DomesticAnimal {
	
}
```

And while I am at it, we should put `Dog` and `Cat` into a `Pet`. This will allow me to have `Cow`, `Horse`, etc as domestic animals, but not as a `Pet`.


```java
class Pet extends DomesticAnimal {
	
}

class Dog extends Pet {
	
}

class Cat extends Pet {
	
}
```

Ok, good. We got this covered now. Or do we? I have a pet fish. Fish do not run. Fish do not have legs. I am stuck. This means if I go all the way up to `Animal`, I have branch off into `LeggedAnimal` and work my way down to `Pet`. Yet a `Fish` is a pet and it is not a `LeggedAnimal`. Maybe its not even a `DomesticAnimal`. This means I would have to have another inheritance chain branching from `Animal` that resolves into `Pet`, that is not `LeggedAnimal` and maybe not even `DomesticAnimal`, yet I cannot have two classes of `Pet`. Everything is broken now.

Welcome to the nightmare. Fortunately for us, we alleviate this with *interfaces* and restrict our inheritance to 
small features that we will know will not conflict later, like `sex`.

## Forcing methods to be created via inheritance of classes.
Let us drop this whole inheritance nightmare issue for now. We will understand how to handle it properly when we get to `Interfaces`. For
 now, lets just focus on `sex` and add a method to `Animal` called `procreate`. Yes, this is a *science* class, so no laughing. 
 
We know *every* animal has to procreate for the species to survive, but literally pretty much every animal procreates
 differently. So there is no way to define how that method should work, but we want *every* animal species to survive, and to do so, it needs to procreate.
 . To handle this, we will force every immediate child class to implement their own version of procreation.
 
```java
abstract class Animal {
	String sex;
	abstract public void procreate();
}
```

Here we leverage the `abstract` keyword. This keyword simply means that the parent class has no idea how to implement
 it, but every class inheriting `Animal` has to come up with its own functionality. Furthermore, since we do not want
  to be an `Animal` who cannot `procreate`, we make the class `abstract`. This prevents us from instantiating the 
  `Animal` class directly. 
  
Now, if we extend this into `Fish`, we can have the following:

```java
class Fish extends Animal{
	String sex = "female";
	public void procreate(){ this.layEggs(); }
}
```

We manually overrode the sex to female and we implemented `procreate` to `layEggs()`. What about `layEggs()`, where 
did that come from? Well, for now, it is just a place holder. Later when we create interfaces we will revisit this 
method. But lets blackbox that and assume all is good, now lets create a `Bird`

```java
class Bird extends Animal{
	String sex = "female";
	public void procreate(){ this.layEggs(); }
}
```

Pretty much the same, huh? Well again. That is because of the *imaginary* interface. For giggles, or a preview if you
 will, lets assume an interface named `EggLayer` existed. It will force us also to implement a method `layEggs`.
 
```java
class Fish extends Animal implements EggLayer {
	String sex = "female";
	public void procreate(){ this.layEggs(); }
	public void layEggs(){ //lay eggs like a fish }
}

class Bird extends Animal implements EggLayer {
	String sex = "female";
	public void procreate(){ this.layEggs(); }
	public void layEggs(){ // lay eggs like a bird }
}
```
 
Now maybe that makes more sense, but how we handle this and why will come up in a later section.


## The `super` method
Yes, java has a `super` method. It can be used in constructors or methods to call the parent constructor/method from 
the child constructor/method.

Examples:

```java
class Parent {
	String name;
	Parent(String name){ this.name = name; }
	void sayName(){ 
		System.out.println("Say my name, say my name");
	}
}

class Child extends Parent {
	Child(String name){
		super(name);
	}
	
	String sayName(){ 
		super.sayName();
		System.out.println("If no one is around you, say baby I love you");
	}
}
```
Here, if we only instantiated `Parent`, it is pretty obvious what is happening when we construct or call `sayName`. 
But if we instantiate `Child`, on the constructor, we leverage the parents code to set the name, and on `sayName`, 
which overloads the parent, we call the parents method which prints `Say my name, Say my name`, then we print `If no 
one is around you say baby I love you`. Its that easy, but one caveat, anytime you call `super`, either as a constructor or to access a method, it must come first. No exceptions.


