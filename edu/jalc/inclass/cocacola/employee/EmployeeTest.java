package edu.jalc.inclass.cocacola.employee;

import edu.jalc.inclass.cocacola.security.PinNumber;

public class EmployeeTest {

	public void testNameOnlyConstructor(){
		System.out.println("Testing Employee(String name)");
      Employee employee = new Employee("Nour");
      assert(employee.getName().equals("Nour"));
	}

	public void testNameAndPinConstructor(){
		System.out.println("Testing Employee(String name, PinNumber pinNumber)");
       PinNumber pinNumber = new PinNumber(8);
       Employee employee = new Employee("Nour",pinNumber);
      assert(employee.getName().equals("Nour")&& employee.getPinNumber()== pinNumber);
	}
	
	public void testSetPinNUmber(){
		System.out.println("Testing Employee::setPinNumber");
      PinNumber pinNumber =new PinNumber(7);
      Employee employee = new Employee("Nour",pinNumber);
      employee.setPinNumber(pinNumber);
		assert(employee.getPinNumber() == pinNumber);
	}

	public void testGetName(){
		System.out.println("Testing Employee::getName");
       Employee employee = new Employee("Nour");
		assert(employee.getName().equals("Nour"));
	}

	public void testGetPinNumber(){
		System.out.println("Testing Employee::getPinNumber");
      PinNumber pinNumber =new PinNumber(7);
      Employee employee = new Employee("Nour",pinNumber);
		assert(employee.getPinNumber() == pinNumber);
		
	}

	public void testToString(){
		System.out.println("Testing Employee::toString");
      PinNumber pinNumber =new PinNumber(7);
      Employee employee = new Employee("Nour",pinNumber);
		assert(employee.toString().equals(employee.getName() + "::" + employee.getPinNumber().toString()));
	}

	public static void main(String... args){
		EmployeeTest employeeTest = new EmployeeTest();
		employeeTest.testNameOnlyConstructor();
		employeeTest.testNameAndPinConstructor();
		employeeTest.testSetPinNUmber();
		employeeTest.testGetName();
		employeeTest.testGetPinNumber();
		employeeTest.testToString();
	}
}
