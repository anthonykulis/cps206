package oop_pillars.inheritance.basic;

class Cat extends DomesticAnimal {
	public void lickHuman(){
		super.lickHuman();
		switch(this.sex){
			case "male": System.out.println("Then the cat runs off with the enterance of the dog"); break;
			case "female": System.out.println("Then the cat jumps on your head when the dog starts to bark");
		}
	}
}