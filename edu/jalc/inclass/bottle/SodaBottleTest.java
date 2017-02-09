package edu.jalc.inclass.bottle;

import edu.jalc.inclass.label.SodaBottleLabel;
import edu.jalc.inclass.lid.SodaBottleLid;
import edu.jalc.inclass.liquid.Soda;

public class SodaBottleTest {

	public void testGetCapacity() throws Exception {
		System.out.println("Testing SodaBottle::getCapacity");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(1,1), null, null);
		assert(sodaBottle.getCapacity() == 20.0);
	}

	public void testSetLid() throws Exception {
		System.out.println("Testing SodaBottle::setLid");
		SodaBottle sodaBottle = new SodaBottle(20.0, new SodaBottleLid(2,3), null, null);
		SodaBottleLid lid = new SodaBottleLid(1,1);
		sodaBottle.setLid(lid);
		assert(lid == sodaBottle.getLid());
	}

	public void testSetLidWithException() throws Exception {
		System.out.println("Testing SodaBottle::setLid for exception");
		boolean exceptionThrown = false;
		try {
			new SodaBottle(20.0, null, null, null);
		} catch (Exception e){
			exceptionThrown = true;
		}

		assert(exceptionThrown);
	}

	public void testGetSoda() throws Exception {
		System.out.println("Testing SodaBottle.getSoda");
		Soda soda = new Soda(1.0);
		SodaBottle sodaBottle = new SodaBottle(1.0, new SodaBottleLid(1,1), soda, null);
		assert(soda == sodaBottle.getSoda());
	}

	public void testGetLabel() throws Exception {
		System.out.println("Testing SodaBottle::getLabel");
		SodaBottleLabel sodaBottleLabel = new SodaBottleLabel(1.0, null, null);
		SodaBottle sodaBottle = new SodaBottle(1.0, new SodaBottleLid(1,1), null, sodaBottleLabel);
		assert(sodaBottleLabel == sodaBottle.getLabel());
	}

	public static void main(String... args) throws Exception {
		SodaBottleTest sodaBottleTest = new SodaBottleTest();
		sodaBottleTest.testGetCapacity();
		sodaBottleTest.testSetLid();
		sodaBottleTest.testSetLidWithException();
		sodaBottleTest.testGetSoda();
		sodaBottleTest.testGetLabel();

		System.out.println("All SodaBottle Tests passed");
	}
}
