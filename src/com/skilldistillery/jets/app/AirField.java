package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AirField {

	private ArrayList<Jet> jets;

	public AirField(String fileName) {
		jets = new ArrayList<>();
		BufferedReader reader = null;
		String plane = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			Jet j = null;
			while ((plane = reader.readLine()) != null) {

				String[] planeParts = plane.split(", ");
				if (planeParts[0].contentEquals("Cargo Jet")) {
					j = new CargoPlane(planeParts[0], Double.parseDouble(planeParts[1]),
							Integer.parseInt(planeParts[2]), Long.parseLong(planeParts[3]));

				} else if (planeParts[0].contentEquals("Fighter Jet")) {
					j = new FighterJet(planeParts[0], Double.parseDouble(planeParts[1]),
							Integer.parseInt(planeParts[2]), Long.parseLong(planeParts[3]));
				} else {
					j = new JetPlane(planeParts[0], Double.parseDouble(planeParts[1]), Integer.parseInt(planeParts[2]),
							Long.parseLong(planeParts[3]));
				}
				jets.add(j);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirField [jets=").append(jets).append("]");
		return builder.toString();
	}

	public void listFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	public void fly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public void viewFastest() {
		double fastest = 0;

		for (Jet jet : jets) {
			if (fastest < jet.getSpeed()) {
				fastest = jet.getSpeed();
			}
		}

		for (Jet jet : jets) {
			if (fastest == jet.getSpeed()) {
				System.out.println("Fastest: " + jet.toString());
			}
		}
	}

	public void viewLongestRange() {
		double longestR = 0;

		for (Jet jet : jets) {
			if (longestR < jet.getRange()) {
				longestR = jet.getRange();
			}
		}

		for (Jet jet : jets) {
			if (longestR == jet.getRange()) {
				System.out.println("Longest Range: " + jet.toString());
			}
		}

	}

	public void cargo() {
		int i = 1;
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
				System.out.println(jet.getModel() + ": " + i);
				i++;
			}
		}
	}

	public void dogfight() {
		int i = 1;
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
				System.out.println(jet.getModel() + ": " + i);
				i++;
			}
		}
	}

	public void addJet(Scanner scanner) {
		System.out.println("Enter model to add: ");
		String model = scanner.nextLine();
		System.out.println("Enter speed in MPH: ");
		double speed = scanner.nextDouble();
		System.out.println("Enter range in miles: ");
		int range = scanner.nextInt();
		System.out.println("Enter price: ");
		long price = scanner.nextLong();
		scanner.nextLine();

		Jet input = null;
		if (model.contentEquals("Cargo Jet")) {
			input = new CargoPlane(model, speed, range, price);

		} else if (model.contentEquals("Fighter Jet")) {
			input = new FighterJet(model, speed, range, price);
		} else {
			input = new JetPlane(model, speed, range, price);
		}
		jets.add(input);

	}

	public void removeJet(Scanner scanner) {
		int i = 1;
		for (Jet jet : jets) {
			System.out.println(i + ": " + jet.toString());
			i++;
		}

		System.out.println("Enter number to remove: ");
		int index = scanner.nextInt();
		
		jets.remove(index - 1);
	}

}
