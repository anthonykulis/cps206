package classes.advanced;

import java.awt.Toolkit;

public class Dog {
	public void bark(){
		this._makeBeeps(3);
	}
	public void growl(){
		this._makeBeeps(2);
	}
	public void whimper(){
		this._makeBeeps(1);
	}

	private void _makeBeeps(int quantity){
		for(int i = 0; i < quantity; i++){
			Toolkit.getDefaultToolkit().beep();

			// because some systems my not beep w/o threads sleeping
			// this notifies it beeped correctly
			System.out.println("I beeped");
		}
	}

	public static void main(String[] args){
		Dog dog = new Dog();
		switch(args[0]){
			case "bark":
			case "Bark": dog.bark(); break;
			case "growl":
			case "Growl": dog.growl(); break;
			case "whimper":
			case "Whimper": dog.whimper();
		}
	}
}