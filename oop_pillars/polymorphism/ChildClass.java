package oop_pillars.polymorphism;

class ChildClass extends ParentClass implements SomeInterface {


	public void childMethod(){}

	// implements interface
	public void doSomething(){
		System.out.println("I did a child thing");
	}

	// overrides toString
	public String toString(){ return "child"; }

	public static void main(String[] args){
		ChildClass c = new ChildClass();
		ParentClass p = c;
		SomeInterface si = c;

		System.out.println(c);
		System.out.println(p);
		System.out.println(si);

	}
}