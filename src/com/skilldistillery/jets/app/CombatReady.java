package com.skilldistillery.jets.app;

public interface CombatReady {

	default void fight() {
		System.out.println("Engaging in combat.");
	}

}
