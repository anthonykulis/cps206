package edu.jalc.inclass.bottle;

import edu.jalc.inclass.lid.SodaBottleLid;

public class SodaBottleTest {

	public void testGetCapacity() throws Exception {
		System.out.println("Testing SodaBottle::getCapacity");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(1,1));
		assert(sodaBottle.getCapacity() == 20.0);
	}

	public void testSetLid() throws Exception {
		System.out.println("Testing SodaBottle::setLid");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(2,3));
		SodaBottleLid lid = new SodaBottleLid(1,1);
		sodaBottle.setLid(lid);
		assert(lid == sodaBottle.getLid());
	}

	public void testSetLidWithException() throws Exception {
		System.out.println("Testing SodaBottle::setLid for exception");
		boolean exceptionThrown = false;
		try {
			new SodaBottle(20.0, null);
		} catch (Exception e){
			exceptionThrown = true;
		}

		assert(exceptionThrown);
	}

	public static void main(String... args) throws Exception {
		SodaBottleTest sodaBottleTest = new SodaBottleTest();
		sodaBottleTest.testGetCapacity();
		sodaBottleTest.testSetLid();
		sodaBottleTest.testSetLidWithException();

		System.out.println("All SodaBottle Tests passed");
	}
}
