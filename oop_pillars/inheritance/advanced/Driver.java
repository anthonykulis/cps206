package oop_pillars.inheritance.advanced;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Driver {

	public static void main(String... args){
		ArrayList<TwoWheelVehicle> bikes = new ArrayList<>();

		bikes.add(new MotorCycle());
		bikes.add(new MountainBike());
		bikes.add(new RoadBike());
		bikes.add(new Scooter());

		double randomAccel = Math.random() * 100;
		double randomBrake = Math.random() * 5;

		bikes.parallelStream().forEach((bike) -> {
			bike.accelerate(randomAccel).brake(randomBrake);
			System.out.println(bike + " >>> current speed  >>> " + bike.getCurrentSpeed());
		});

		double averageSpeed = bikes.parallelStream().collect(Collectors.averagingDouble(TwoWheelVehicle::getCurrentSpeed));

		System.out.println("Average speed >>> " + averageSpeed);
	}
}
