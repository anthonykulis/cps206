package edu.jalc.inclass.color;

public class RGBColor {
	private final byte red;
	private final byte green;
	private final byte blue;

	private RGBColor(){
		this.red = this.green = this.blue = 0;
	}

	public RGBColor(byte red, byte green, byte blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public byte getRed() {
		return red;
	}

	public byte getGreen() {
		return green;
	}

	public byte getBlue() {
		return blue;
	}
}
