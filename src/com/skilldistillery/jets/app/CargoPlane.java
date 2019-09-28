package com.skilldistillery.jets.app;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, String type, double speed, int range, long price) {
		super(model, type, speed, range, price);
	}

}
