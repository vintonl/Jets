package com.skilldistillery.jets.app;

public interface CargoCarrier {

	default void loadCargo() {
		System.out.println(("Loading cargo onto:"));
	}

}
