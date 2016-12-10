package oop_pillars.inheritance.basic;

class WildAnimal extends Animal {

	public void killHuman(){
		switch(sex){
			case "male": System.out.println("The male eats the human"); break;
			case "female": System.out.println("The female squishes the human");
		}
	}
}