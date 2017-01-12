package oop_pillars.inheritance.advanced;

abstract class TwoWheelVehicle {
	double currentSpeed = 0;
	double modifier = 0;
	double modifierScalar = 0;

	TwoWheelVehicle(double modifier, double modifierScalar){
		this.modifierScalar = modifierScalar;
		this.modifier = modifier;
	}

	public TwoWheelVehicle accelerate(double speed){
		adjustSpeed(speed, false);
		return this;
	}

	public TwoWheelVehicle brake(double speed){
		adjustSpeed(speed, true);
		return this;
	}


	private void adjustSpeed(double speed, boolean negate){

		speed = speed * modifier * modifierScalar;
		if(negate) speed *= -1;
		currentSpeed += speed;

	}

	public double getCurrentSpeed(){ return currentSpeed; }
}
