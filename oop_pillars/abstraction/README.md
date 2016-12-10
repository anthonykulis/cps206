# Abstraction 
Abstraction is an OOP pillar that states features of multiple objects that they have in common can be removed and 
placed into one parent object. 


Imagine a dog and a cat.


```java
class Dog {
	String sex;
	String breed;
	void run(){}
	void bark(){}
}

class Cat {
	String sex;
	String breed;
	void run(){}
	void meow(){}
}
```

We can see that `sex`, `breed`, and `run` are three things these two classes have in common. This means we should 
abstract them into a parent class.

```java
class Animal {
	String sex;
	String breed;
	void run(){}
}

class Dog extends Animal {
	void bark(){}
}

class Cat extends Animal {
	void meow();
}
```

Now, via inheritance, the abstractions to `Animal` are no longer repetitive.