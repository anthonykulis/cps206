package oop_pillars.inheritance.basic;

class Bear extends WildAnimal {
	public void killHuman(){
		super.killHuman();
		switch(this.sex){
			case "male": System.out.println("Then the bear burps"); break;
			case "female": System.out.println("Then the mother bear walks her babies away");
		}
	}
}