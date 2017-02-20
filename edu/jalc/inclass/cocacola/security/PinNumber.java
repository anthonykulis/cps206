package edu.jalc.inclass.cocacola.security;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PinNumber {
   private final int pin;
   private final Calendar expiresOn;

   private PinNumber(){
      this.pin = -1;
      this.expiresOn = Calendar.getInstance();
      this.expiresOn.add(Calendar.DATE, -1);
   }

   public PinNumber(int pin){
      this.pin = pin;
      this.expiresOn = Calendar.getInstance();
      this.expiresOn.add(Calendar.DATE, 365);
   }

   public int getPin(){
      return this.pin;
   }

   public String getExpirationDate(){
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      return dateFormat.format(this.expiresOn.getTime());
   }
}
