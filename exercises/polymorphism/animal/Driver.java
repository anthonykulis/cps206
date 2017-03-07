package exercises.polymorphism.animal;

import java.util.ArrayList;

public class Driver {

	public static void animalSays(Animal animal){
		System.out.println(animal);
	}

	public static void main(String... args){
		ArrayList<Animal> animals = new ArrayList<>();

		// step 1
		System.out.println("Step 1");
		animals.add(new Cat("meow", "purr", "errr"));
		animals.add(new Dog("woof", "whimper", "errr"));
		
		for(Animal animal : animals){
			Driver.animalSays(animal);
		}

		// step 2
		System.out.println("\nStep 2");
		animals.add(new Bear("errr"));

		for(Animal animal : animals){
			Driver.animalSays(animal);
		}

	}
}
