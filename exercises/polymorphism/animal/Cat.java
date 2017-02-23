package exercises.polymorphism.animal;

public class Cat extends Animal {

	String meow;
	String purr;

	private Cat(){
		super(null);
	}

	public Cat(String meow, String purr, String growl){
		super(growl);
		this.purr = purr;
		this.meow = meow;
	}

}
