package exercises;

public class BrokenCode {

	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		// broken!!!!
		return "not your name " + name;
	}

	public double toCentimeters(double inches){

		// broken!!!!
		return 3.0 * inches;
	}

	/*
		When creating classes, if that class doesn't require a Driver, it should be tested.

		While jUnit, Spock, etc are acceptable and encouraged, you are free to test in the
		main method.

		Use the following for an example
	 */
	public static void main(String... args){

		// create my instance of the test subject (this class)
		BrokenCode brokenPojo = new BrokenCode();

		brokenPojo.testSetGetName();
		brokenPojo.testInchesToCentimeters();

	}

	/* Start tests - will not test w/o -ea flag */


	// test set/get name
	private void testSetGetName(){

		// argument I will use to test
		String name = "anthony";

		// one method under test
		this.setName(name);

		// second method under test
		String broken = this.getName();


		// my expected style with : operator, second half is your detail on its failure
		assert broken.equals(name) : "name in pojo is not `" + name + "` but rather `" + broken + "`";
	}

	// test toCentimeters
	private void testInchesToCentimeters(){
		double centimeters = this.toCentimeters(3.0);
		assert centimeters == 3.0 * 2.54 : "3 inches converted to centimeters does not equal " + centimeters;
	}

}
