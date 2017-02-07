package edu.jalc.inclass.bottle;

public class SodaBottleTest {

	public void testGetCapacity(){
		System.out.println("Testing SodaBottle::getCapacity");
		SodaBottle sodaBottle = new SodaBottle();
		assert(sodaBottle.getCapacity() == 20.0);
	}

	public static void main(String... args){
		SodaBottleTest sodaBottleTest = new SodaBottleTest();
		sodaBottleTest.testGetCapacity();

		System.out.println("All SodaBottle Tests passed");
	}
}
