package oop_pillars.polymorphism;

class AnotherClass extends ParentClass implements SomeInterface {
	void anotherMethod(){}
	public void doSomething(){
		// do something for another
		System.out.println("I did another thing");
	}
	public String toString(){ return "another class"; }
}