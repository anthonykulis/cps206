package edu.jalc.inclass.label;


import edu.jalc.inclass.color.RGBColor;
import edu.jalc.inclass.logo.CocaColaLogo;

public class SodaBottleLabel {

	private final double height;
	private final RGBColor rgbColor;
	private final CocaColaLogo cocaColaLogo;

	private SodaBottleLabel(){
		this.height = 0;
		this.rgbColor = null;
		this.cocaColaLogo = null;
	}

	public SodaBottleLabel(double height, RGBColor rgbColor, CocaColaLogo cocaColaLogo){
		this.height = height;
		this.rgbColor = rgbColor;
		this.cocaColaLogo = cocaColaLogo;
	}

	public double getHeight() {
		return height;
	}

	public RGBColor getRgbColor() {
		return rgbColor;
	}

	public CocaColaLogo getCocaColaLogo() {
		return cocaColaLogo;
	}
}
