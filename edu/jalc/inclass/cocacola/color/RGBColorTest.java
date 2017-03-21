package edu.jalc.inclass.cocacola.color;

public class RGBColorTest {

   public void testGetRed(){
      System.out.println("Testing RGBColor::getRed");
      RGBColor color = new RGBColor((byte)4, (byte)8, (byte)3);
      assert((byte)4 == color.getRed());
   }

   public void testGetGreen(){
      System.out.println("Testing RGBColor::getGreen");
      RGBColor color = new RGBColor((byte)7, (byte)16, (byte)9);
      assert((byte)16 == color.getGreen());
   }
   
   public void testGetBlue(){
      System.out.println("Testing RGBColor::getBlue");
      RGBColor color = new RGBColor((byte)21, (byte)34, (byte)21);
      assert((byte)21 == color.getBlue());
   }

   public static void main(String[] args){
      RGBColorTest test = new RGBColorTest();
      test.testGetRed();
      test.testGetGreen();
      test.testGetBlue();
      System.out.println("All Tests for RGBColor Passed");
   } 
}
