package oop_pillars.inheritance.basic;

class Dinosaur extends WildAnimal {
	public void killHuman(){
		super.killHuman();
		switch(this.sex){
			case "male": System.out.println("No male dinosaurs actually killed any humans"); break;
			case "female": System.out.println("No female dinosaurs actually killed any humans");
		}
	}
}