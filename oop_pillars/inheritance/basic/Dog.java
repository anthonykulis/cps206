package oop_pillars.inheritance.basic;

class Dog extends DomesticAnimal {
	public void lickHuman(){
		super.lickHuman();
		switch(this.sex){
			case "male": System.out.println("Then the dog rolls over"); break;
			case "female": System.out.println("The dog goes off to eat the cats food");
		}
	}
}