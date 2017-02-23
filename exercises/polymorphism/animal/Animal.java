package exercises.polymorphism.animal;

abstract public class Animal {

	private String growls;

	private Animal(){
		this.growls = null;
	}

	Animal(String growls){
		this.growls = growls;
	}

	String getGrowl(){
		return this.growls;
	}

}
