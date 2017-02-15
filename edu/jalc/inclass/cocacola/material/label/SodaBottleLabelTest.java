package edu.jalc.inclass.cocacola.material.label;

import edu.jalc.inclass.cocacola.color.RGBColor;
import edu.jalc.inclass.cocacola.material.logo.CocaColaLogo;

public class SodaBottleLabelTest {

	public void testGetHeight(){
		System.out.println("Testing SodaBottleLabel::getHeight");
		SodaBottleLabel sodaBottleLabel = new SodaBottleLabel(1.0, null, null);
		assert(sodaBottleLabel.getHeight() == 1.0);
	}

	public void testGetRGBColor(){
		System.out.println("Testing SodaBottleLabel::getRGBColor");
		RGBColor rgbColor = new RGBColor((byte)1,(byte)1,(byte)1);
		SodaBottleLabel sodaBottleLabel = new SodaBottleLabel(1.0, rgbColor, null);
		assert(sodaBottleLabel.getRgbColor() == rgbColor);
	}

	public void testGetCocaColaLogo(){
		System.out.println("Testing SodaBottleLabel::getCocaColaLogo");
		CocaColaLogo cocaColaLogo = new CocaColaLogo(1.0);
		SodaBottleLabel sodaBottleLabel = new SodaBottleLabel(1.0, null, cocaColaLogo);
		assert(sodaBottleLabel.getCocaColaLogo() == cocaColaLogo);
	}


	public static void main(String... args){
		SodaBottleLabelTest sodaBottleLabelTest = new SodaBottleLabelTest();
		sodaBottleLabelTest.testGetHeight();
		sodaBottleLabelTest.testGetCocaColaLogo();
		sodaBottleLabelTest.testGetRGBColor();
		System.out.println("SodaBottleLabelTest complete");
	}
}
