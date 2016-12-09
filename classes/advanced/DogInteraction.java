package classes.advanced;

import java.util.Scanner;

public class DogInteraction {

	private final Dog dog = new Dog();

	public String askUserForDogSound(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("What sound should the dog make?");
		return scanner.nextLine();
	}

	public DogInteraction commandDogTo(String action){
		switch(action){
			case "bark": this.dog.bark(); break;
			case "growl": this.dog.growl(); break;
			case "whimper": this.dog.whimper();
		}

		return this;
	}
	public static void main(String[] args){
		DogInteraction di = new DogInteraction();
		if(args.length > 0){
			di.commandDogTo(args[0]);
		} else {
			di.commandDogTo(di.askUserForDogSound());
		}

	}
}