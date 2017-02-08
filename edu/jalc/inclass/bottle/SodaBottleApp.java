package edu.jalc.inclass.bottle;

import edu.jalc.inclass.lid.SodaBottleLid;

public class SodaBottleApp {

	public static void main(String... args) throws Exception {
		SodaBottle sodaBottle = new SodaBottle(20, new SodaBottleLid(1, 2));
		System.out.println("Capacity: " + sodaBottle.getCapacity());
	}
}
