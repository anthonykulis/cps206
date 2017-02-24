package edu.jalc.inclass.cocacola.manufacturing;

import edu.jalc.inclass.cocacola.material.bottle.SodaBottle;
import edu.jalc.inclass.cocacola.material.label.SodaBottleLabel;
import edu.jalc.inclass.cocacola.material.lid.SodaBottleLid;
import edu.jalc.inclass.cocacola.product.liquid.Soda;

public class SodaBottleFillerTest {

	public void testGetInstance(){
		System.out.println("Testing SodaBottleFiller::getInstance");
		SodaBottleFiller sodaBottleFiller = SodaBottleFiller.getInstance();
		assert(sodaBottleFiller == sodaBottleFiller.getInstance());
	}

	public void testFillSoda() throws Exception{
		System.out.println("Testing SodaBottleFiller::fillSoda");
		SodaBottleLid sodaBottleLid = new SodaBottleLid(1,1);
		Soda soda = new Soda(0.0);
		SodaBottle sodaBottle = new SodaBottle(0.0, sodaBottleLid, soda, null);
		sodaBottle.setSoda(soda);
		SodaBottleFiller sodaBottleFiller = SodaBottleFiller.getInstance();
		sodaBottleFiller.fillSoda(sodaBottle);
		assert(soda.getVolume() == sodaBottle.getCapacity());
	}

	public static void main(String... args) throws Exception{
		SodaBottleFillerTest sodaBottleFillerTest = new SodaBottleFillerTest();
		sodaBottleFillerTest.testGetInstance();
		sodaBottleFillerTest.testFillSoda();
		System.out.println("Completed testing SodaBottleFiller");
	}
}
