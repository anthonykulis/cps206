package oop_pillars.inheritance.basic;

class DomesticAnimal extends Animal {

	public void lickHuman(){
		switch(this.sex){
			case "male": System.out.println("The male licks his butt then the humans face"); break;
			case "female": System.out.println("The female just stares coldly at the human");
		}
	}
}