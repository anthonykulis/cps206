package edu.jalc.inclass.logo;

public class CocaColaLogo {
	private final double height;

	private CocaColaLogo(){
		this.height = 0;
	}

	public CocaColaLogo(double height){
		this.height = height;
	}

	public double getHeight(){
		return this.height;
	}
}
