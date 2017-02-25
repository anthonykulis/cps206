package edu.jalc.inclass.cocacola.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PinNumberTest {

   public void testGetPin(){
      System.out.println("Testing PinNumber::getPin");
      PinNumber pinNumber =new PinNumber(4);
      assert(pinNumber.getPin() == 4);
   }

   public void testGetExpirationDate(){
      System.out.println("Testing PinNumber::getPin");
      PinNumber pinNumber = new PinNumber(0);
      Calendar expiresOn = Calendar.getInstance();
      expiresOn.add(Calendar.DATE, 365);
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      assert(pinNumber.getExpirationDate().equals(dateFormat.format(expiresOn.getTime())));
   }


   public static void main(String... args){
      PinNumberTest pinNumberTest = new PinNumberTest();
      pinNumberTest.testGetPin();
      pinNumberTest.testGetExpirationDate();
      System.out.println("Completed testing PinNumber");
   
   }

}
