package edu.jalc.inclass.liquid;

public class SodaTest {

	public void testSetVolume(){
		System.out.println("Testing Soda::setVolume");
		Soda soda = new Soda();
		soda.setVolume(4.0);
		assert(soda.getVolume() == 4.0);
	}

	public static void main(String... args){

		SodaTest sodaTest = new SodaTest();
		sodaTest.testSetVolume();
		System.out.println("Soda Tests Complete");
	}
}
