package edu.jalc.inclass.cocacola.employee;

import edu.jalc.inclass.cocacola.security.PinNumber;

public class EmployeeTest {

   public void testNameOnlyConstructor(){
      System.out.println("Testing Employee(String name)");
      Employee employee = new Employee("John", null);
      assert(employee.getName().equals("John"));
   }

   public void testNameAndPinConstructor(){
      System.out.println("Testing Employee(String name, PinNumber pinNumber)");
      PinNumber pinNumber = new PinNumber(0);
      Employee employee = new Employee("John", pinNumber);
      assert(employee.getName().equals("John") && employee.getPinNumber() == pinNumber);
   }

   public void testSetPinNumber(){
      System.out.println("Testing Employee::setPinNumber");
      Employee employee = new Employee("John", null);
      PinNumber pinNumber = new PinNumber(3);
      employee.setPinNumber(pinNumber);
      assert(employee.getPinNumber() == pinNumber);
   }

   public void testGetName(){
      System.out.println("Testing Employee::getName");
      Employee employee = new Employee("John", null);
      assert(employee.getName().equals("John"));
   }

   public void testGetPinNumber(){
      System.out.println("Testing Employee::getPinNumber");
      PinNumber pinNumber = new PinNumber(0);
      Employee employee = new Employee("John", pinNumber);
      assert(employee.getPinNumber() == pinNumber);	
   }

   public void testToString(){
      System.out.println("Testing Employee::toString");
      PinNumber pinNumber = new PinNumber(0);
      Employee employee = new Employee("John", pinNumber);
      assert(employee.toString().equals(employee.getName() + "::" + employee.getPinNumber().toString()));
   }

   public static void main(String... args){
      EmployeeTest employeeTest = new EmployeeTest();
      employeeTest.testNameOnlyConstructor();
      employeeTest.testNameAndPinConstructor();
      employeeTest.testSetPinNumber();
      employeeTest.testGetName();
      employeeTest.testGetPinNumber();
      employeeTest.testToString();
   }
}
