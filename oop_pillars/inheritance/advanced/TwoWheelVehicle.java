package oop_pillars.inheritance.advanced;

abstract class TwoWheelVehicle {
	private double currentSpeed = 0;
	private double modifier = 0;
	private double modifierScalar = 0;

	TwoWheelVehicle(double modifier, double modifierScalar){
		this.modifierScalar = modifierScalar;
		this.modifier = modifier;
	}

	TwoWheelVehicle accelerate(double speed){
		adjustSpeed(speed, false);
		return this;
	}

	TwoWheelVehicle brake(double speed){
		adjustSpeed(speed, true);
		return this;
	}

	private void adjustSpeed(double speed, boolean negate){
		speed = speed * modifier * modifierScalar;
		if(negate) speed *= -1;
		currentSpeed += speed;
	}

	double getCurrentSpeed(){ return currentSpeed; }
}
