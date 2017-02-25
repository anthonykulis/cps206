package edu.jalc.inclass.cocacola.manufacturing;

import edu.jalc.inclass.cocacola.material.bottle.SodaBottle;
import edu.jalc.inclass.cocacola.material.lid.SodaBottleLid;
import edu.jalc.inclass.cocacola.product.liquid.Soda;

public class SodaBottleFillerTest {

   public void testGetInstance(){
      System.out.println("Testing SodaBottleFiller::getInstance");
      SodaBottleFiller sodaBottleFiller =  SodaBottleFiller.getInstance();
      assert(sodaBottleFiller.getInstance()== sodaBottleFiller  );
   }

   public void testFillSoda()throws Exception{
      System.out.println("Testing SodaBottleFiller::fillSoda");
   
      Soda soda = new Soda(10);
      SodaBottleLid lid = new SodaBottleLid(0,0); 
      SodaBottle sodaBottle = new SodaBottle(10.0,lid,soda, null);
      SodaBottleFiller sodaBottleFiller = SodaBottleFiller.getInstance();
      sodaBottleFiller.fillSoda(sodaBottle);
      assert(soda.getVolume() == sodaBottle.getCapacity());
   }

   public static void main(String... args)throws Exception{
      SodaBottleFillerTest sodaBottleFillerTest = new SodaBottleFillerTest();
      sodaBottleFillerTest.testGetInstance();
      sodaBottleFillerTest.testFillSoda();
      System.out.println("Completed testing SodaBottleFiller");
   }
}
