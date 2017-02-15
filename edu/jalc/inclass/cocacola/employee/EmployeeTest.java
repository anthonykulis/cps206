package edu.jalc.inclass.cocacola.employee;

public class EmployeeTest {

	public void testNameOnlyConstructor(){
		System.out.println("Testing Employee(String name)");
		assert(false);
	}

	public void testNameAndPinConstructor(){
		System.out.println("Testing Employee(String name, PinNumber pinNumber)");
		assert(false);
	}

	public void testSetPinNUmber(){
		System.out.println("Testing Employee::setPinNumber");
		assert(false);
	}

	public void testGetName(){
		System.out.println("Testing Employee::getName");
		assert(false);
	}

	public void testGetPinNumber(){
		System.out.println("Testing Employee::getPinNumber");
		assert(false);
	}

	public void testToString(){
		System.out.println("Testing Employee::toString");
		assert(false);
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
