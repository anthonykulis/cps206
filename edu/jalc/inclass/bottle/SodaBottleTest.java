package edu.jalc.inclass.bottle;

import edu.jalc.inclass.lid.SodaBottleLid;
import edu.jalc.inclass.liquid.Soda;

public class SodaBottleTest {

	public void testGetCapacity() throws Exception {
		System.out.println("Testing SodaBottle::getCapacity");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(1,1), null);
		assert(sodaBottle.getCapacity() == 20.0);
	}

	public void testSetLid() throws Exception {
		System.out.println("Testing SodaBottle::setLid");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(2,3), null);
		SodaBottleLid lid = new SodaBottleLid(1,1);
		sodaBottle.setLid(lid);
		assert(lid == sodaBottle.getLid());
	}

	public void testSetLidWithException() throws Exception {
		System.out.println("Testing SodaBottle::setLid for exception");
		boolean exceptionThrown = false;
		try {
			new SodaBottle(20.0, null, null);
		} catch (Exception e){
			exceptionThrown = true;
		}

		assert(exceptionThrown);
	}

	public void testGetSoda() throws Exception {
		System.out.println("Testing SodaBottle.getSoda");
		Soda soda = new Soda(1.0);
		SodaBottle sodaBottle = new SodaBottle(1.0, new SodaBottleLid(1,1), soda);
		assert(soda == sodaBottle.getSoda());
	}

	public static void main(String... args) throws Exception {
		SodaBottleTest sodaBottleTest = new SodaBottleTest();
		sodaBottleTest.testGetCapacity();
		sodaBottleTest.testSetLid();
		sodaBottleTest.testSetLidWithException();
		sodaBottleTest.testGetSoda();

		System.out.println("All SodaBottle Tests passed");
	}
}
