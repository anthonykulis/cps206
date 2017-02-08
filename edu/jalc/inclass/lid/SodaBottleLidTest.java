package edu.jalc.inclass.lid;

public class SodaBottleLidTest {

	public void testGetHeight(){
		System.out.println("Testing SodaBottleLid::getHeight");
		SodaBottleLid lid = new SodaBottleLid(1.5,2.5);
		assert(1.5 == lid.getHeight());
	}

	public void testGetRadius(){
		System.out.println("Testing SodaBottleLid::getRadius");
		SodaBottleLid lid = new SodaBottleLid(1.4, 2.3);
		assert(2.3 == lid.getRadius());
	}

	public void testAttach(){
		System.out.println("Testing SodaBottleLid::attach");
		SodaBottleLid lid = new SodaBottleLid(1,1);
		lid.attach();
		assert(lid.isAttached());
	}

	public void testDetach(){
		System.out.println("Testing SodaBottleLid::detach");
		SodaBottleLid lid = new SodaBottleLid(1,1);
		lid.detach();
		assert(!lid.isAttached());
	}

	public static void main(String... args) throws Exception {
		SodaBottleLidTest test = new SodaBottleLidTest();
		test.testGetHeight();
		test.testGetRadius();
		test.testAttach();
		test.testDetach();

		System.out.println("All SodaBottleLid Tests passed");
	}
}
