package edu.jalc.inclass.cocacola.manufacturing;

import edu.jalc.inclass.cocacola.material.bottle.SodaBottle;
import edu.jalc.inclass.cocacola.material.label.SodaBottleLabel;
import edu.jalc.inclass.cocacola.material.lid.SodaBottleLid;
import edu.jalc.inclass.cocacola.product.liquid.Soda;

public class SodaBottleFillerTest {

   public void testGetInstance(){
      System.out.println("Testing SodaBottleFiller::getInstance");
      SodaBottleFiller sodaBottleFiller = SodaBottleFiller.getInstance();
      assert(sodaBottleFiller.getInstance() == sodaBottleFiller);
   }

   public void testFillSoda() throws Exception{
      System.out.println("Testing SodaBottleFiller::fillSoda");
      SodaBottleLid lid = new SodaBottleLid(3, 4);
      Soda soda = new Soda(9.5);
      SodaBottle bottle = new SodaBottle(20.0, lid, soda, null);
      bottle.setSoda(soda);
      SodaBottleFiller sodaBottleFiller = SodaBottleFiller.getInstance();
      sodaBottleFiller.fillSoda(bottle);
      assert(bottle.getCapacity() == soda.getVolume());
   }

   public static void main(String[] args) throws Exception{
      SodaBottleFillerTest test = new SodaBottleFillerTest();
      test.testGetInstance();
      test.testFillSoda();
      System.out.println("All Tests for SodaBottleFiller Passed");
   }
}
