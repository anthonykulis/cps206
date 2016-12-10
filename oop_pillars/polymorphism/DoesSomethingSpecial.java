package oop_pillars.polymorphism;

class DoesSomethingSpecial {
	public void doIt(SomeInterface si){
		si.doSomething();

		// while we are at it, try this
		System.out.println(si);
	}

	public static void main(String[] args){
		ChildClass c = new ChildClass();
		AnotherClass a = new AnotherClass();

		DoesSomethingSpecial d = new DoesSomethingSpecial();
		d.doIt(c);
		d.doIt(a);
	}
}