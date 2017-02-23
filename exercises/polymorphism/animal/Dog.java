package exercises.polymorphism.animal;

public class Dog extends Animal {

	String bark;
	String whimper;

	private Dog(){
		super(null);
	}

	public Dog(String bark, String growl, String whimper){
		super(growl);
		this.bark = bark;
		this.whimper = whimper;
	}
}
