package edu.jalc.inclass.liquid;

public class Soda {

	private double volume;

	public Soda(){
		this.setVolume(0.0);
	}

	public Soda(double volume){
		this.setVolume(volume);
	}

	public double getVolume(){ return this.volume; }

	public Soda setVolume(double volume){
		this.volume = volume;
		return this;
	}
}
