package edu.jalc.inclass.cocacola.material.logo;

public class CocaColaLogoTest {

	public void testGetHeight(){
		System.out.println("Testing CocaColaLogo::getHeight");
		CocaColaLogo cocaColaLogo = new CocaColaLogo(2.0);
		assert(cocaColaLogo.getHeight() == 2.0);

	}

	public static void main(String... args){
		CocaColaLogoTest cocaColaLogoTest = new CocaColaLogoTest();
		cocaColaLogoTest.testGetHeight();
		System.out.println("CocaColaLogoTest completed");
	}
}
