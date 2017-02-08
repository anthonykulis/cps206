package edu.jalc.inclass.lid;

public class SodaBottleLid {

	private boolean attached;
	private final double height;
	private final double radius;

	private SodaBottleLid(){
		this.attached = false;
		this.height = this.radius = 0;
	}

	public SodaBottleLid(double height, double radius){
		this.height = height;
		this.radius = radius;
		this.attached = false;
	}

	public double getHeight(){ return this.height; }
	public double getRadius(){ return this.radius; }
	public boolean isAttached(){ return this.attached; }

	public SodaBottleLid attach(){
		this.setAttached(true);
		return this;
	}

	public SodaBottleLid detach(){
		this.setAttached(false);
		return this;
	}

	private void setAttached(boolean attached){
		this.attached = attached;
	}

}
