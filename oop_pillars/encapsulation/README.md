# Encapsulation

Encapsulation is an OOP principal that states imperative logic should be *encapsualted* into a method. That the 
functionality of the action should not be "visible" to the user or require the user to have to configure it more 
than necessary.

Example:

```java

class Dog {
	void bark(){
		// no need for the user of your class to know 
		// how to bark. They just need to call dog.bark();
	}
}
```