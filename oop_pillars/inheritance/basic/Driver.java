package oop_pillars.inheritance.basic;

public class Driver {
	public static void main(String[] args){
		Cat c = new Cat();
		Dog d = new Dog();
		Dinosaur dino = new Dinosaur();
		Bear bear = new Bear();

		c.setSex("female");
		d.setSex("male");
		dino.setSex("male");
		bear.setSex("female");

		c.lickHuman();
		d.lickHuman();
		dino.killHuman();
		bear.killHuman();
	}
}