package edu.jalc.inclass.cocacola.employee;

import edu.jalc.inclass.cocacola.security.PinNumber;

public class EmployeeTest {

   public void testEmployeeName(){
      System.out.println("Testing Employee::Employee(name)");
      String name = "Will";
      Employee employee = new Employee(name);
      assert(employee.getName().equals(name));
   }

   public void testEmployeeNameAndPin(){
      System.out.println("Testing Employee::Employee(name and pinNumber)");
      String name = "Will";
      PinNumber pin = new PinNumber(2134);
      Employee employee = new Employee(name, pin);
      assert(employee.getName().equals(name) && employee.getPinNumber() == pin);
   }

   public void testSetPinNumber(){
      System.out.println("Testing Employee::setPinNumber");
      String name = "Will";
      PinNumber pin = new PinNumber(2134);
      Employee employee = new Employee(name, pin);
      employee.setPinNumber(pin);
      assert(pin == employee.getPinNumber());
   }
     
   public void testGetPinNumber(){
      System.out.println("Testing Employee::getPinNumber");
      PinNumber pin = new PinNumber(2134);
      Employee employee = new Employee(null, pin);
      assert(pin == employee.getPinNumber());
   }

   public void testGetName(){
      System.out.println("Testing Employee::getName");
      String name = "Will";
      Employee employee = new Employee(name);
      assert(employee.getName().equals(name));
   }

   public void testToString(){
      System.out.println("Testing Employee::toString");
      String name = "Will";
      PinNumber pin = new PinNumber(2134);
      Employee employee = new Employee(name, pin);
      assert(employee.toString().equals(employee.getName() + "::" + employee.getPinNumber().toString()));
   }

   public static void main(String[] args){
      EmployeeTest test = new EmployeeTest();
      test.testEmployeeName();
      test.testEmployeeNameAndPin();
      test.testSetPinNumber();
      test.testGetPinNumber();
      test.testGetName();
      test.testToString();
      System.out.println("All Tests for Employee Passed");
   }
}
