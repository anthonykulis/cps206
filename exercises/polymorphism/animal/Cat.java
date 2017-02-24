package exercises.polymorphism.animal;

public class Cat extends Animal {

	private final String meow;
	private final String purr;

	private Cat(){
		super(null);
		this.meow = this.purr = null;
	}

	public Cat(String meow, String purr, String growl){
		super(growl);
		this.purr = purr;
		this.meow = meow;
	}

	public String toString(){
		return "A cat purrs with " + this.purr + " and meows with " + this.meow + " and " + super.toString();
	}

}
