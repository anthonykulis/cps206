package edu.jalc.inclass.cocacola.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PinNumberTest {

   public void testGetPin(){
      System.out.println("Testing PinNumber::getPin");
      PinNumber pin = new PinNumber(2134);
      assert(2134 == pin.getPin());
   }


   public void testGetExpirationDate(){
      System.out.println("Testing PinNumber::getExpirationDate");
      Calendar expiresOn = Calendar.getInstance();
      PinNumber pin = new PinNumber(2134);
      expiresOn.add(Calendar.DATE, 365);
      DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
      assert(pin.getExpirationDate().equals(format.format(expiresOn.getTime())));
   }

   public static void main(String[] args){
      PinNumberTest test = new PinNumberTest();
      test.testGetPin();
      test.testGetExpirationDate();
      System.out.println("All Tests for PinNumber Passed");
   }

}
