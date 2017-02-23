package exercises.polymorphism.animal;

abstract public class Animal {

	private String growl;

	private Animal(){
		this.growl = null;
	}

	Animal(String growl){
		this.growl = growl;
	}

	public String toString(){
		return "growls with " + this.growl;
	}

}
