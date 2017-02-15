package edu.jalc.inclass.cocacola.employee;

import edu.jalc.inclass.cocacola.security.PinNumber;

public class Employee {
	private final String name;
	private PinNumber pinNumber;

	private Employee(){
		this.name = null;
		this.setPinNumber(null);
	}

	public Employee(String name){
		this.name = name;
		this.setPinNumber(new PinNumber(-1));
	}

	public Employee(String name, PinNumber pinNumber){
		this.name = name;
		this.setPinNumber(pinNumber);
	}

	public void setPinNumber(PinNumber pinNumber){
		this.pinNumber = pinNumber;
	}

	public String getName(){
		return this.name;
	}

	public PinNumber getPinNumber(){
		return this.pinNumber;
	}

	public String toString(){
		return this.getName() + "::" + this.getPinNumber().toString();
	}
}
