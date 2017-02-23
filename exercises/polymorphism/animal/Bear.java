package exercises.polymorphism.animal;

public class Bear extends Animal {

	private Bear(){
		super(null);
	}

	public Bear(String growls){
		super(growls);
	}

	public String toString(){
		return "A bear simply " + super.toString();
	}
}
