package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
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
				if (planeParts[1].contentEquals("Cargo Jet")) {
					j = new CargoPlane(planeParts[0], planeParts[1], Double.parseDouble(planeParts[2]),
							Integer.parseInt(planeParts[3]), Long.parseLong(planeParts[4]));

				} else if (planeParts[1].contentEquals("Fighter Jet")) {
					j = new FighterJet(planeParts[0], planeParts[1], Double.parseDouble(planeParts[2]),
							Integer.parseInt(planeParts[3]), Long.parseLong(planeParts[4]));
				} else {
					j = new JetPlane(planeParts[0], planeParts[1], Double.parseDouble(planeParts[2]),
							Integer.parseInt(planeParts[3]), Long.parseLong(planeParts[4]));
				}
				jets.add(j);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
	}

	public void flyJets() {
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
		double longestRange = 0;

		for (Jet jet : jets) {
			if (longestRange < jet.getRange()) {
				longestRange = jet.getRange();
			}
		}

		for (Jet jet : jets) {
			if (longestRange == jet.getRange()) {
				System.out.println("Longest Range: " + jet.toString());
			}
		}
	}

	public void loadCargoJets() {
		int i = 1;
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
				System.out.println(i + ": " + ((CargoPlane) jet).toString());
				i++;
			}
		}
	}

	public void dogfight() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				System.out.println(((FighterJet) jet).toString());
				((FighterJet) jet).fight();
			}
		}
	}

	public void addJet(Scanner scanner) {
		String type = typeMenu(scanner);
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
		if (type.contentEquals("Cargo Jet")) {
			input = new CargoPlane(model, type, speed, range, price);

		} else if (type.contentEquals("Fighter Jet")) {
			input = new FighterJet(model, type, speed, range, price);
		} else {
			input = new JetPlane(model, type, speed, range, price);
		}
		jets.add(input);
	}

	private String typeMenu(Scanner scanner) {
		System.out.println("Menu of Jet Types: ");
		System.out.println("1. Cargo Jet: ");
		System.out.println("2. Fighter Jet: ");
		System.out.println("3. Any other type: ");
		System.out.println("Please choose type: ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		String type = "";
		
		switch (choice) {
		case 1:
			type = "Cargo Jet";
			break;
		case 2:
			type = "Fighter Jet";
			break;
		case 3:
			System.out.println("Enter type: ");
			type = scanner.nextLine();
			scanner.nextLine();
			break;
		default:
			System.err.println("Unexpected value: " + choice);
		}
		
		return type;
	}

	public void removeJet(Scanner scanner) {
		int i = 1;
		for (Jet jet : jets) {
			System.out.println(i + ": " + jet.toString());
			i++;
		}

		int selection = 0;
		System.out.println("Enter number to remove: ");
		try {
			selection = scanner.nextInt();
			scanner.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			selection = 0;
		}

		if (selection != 0 && selection <= jets.size()) {
			jets.remove(selection - 1);
		} else {
			System.err.println("Invalid input.");
		}
	}

	public void save(Scanner scanner, String fileName) {
		System.out.println("Enter new file name to save (include .txt):");
		String saveFile = scanner.nextLine();
		
		if (!saveFile.equalsIgnoreCase(fileName)) {
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileOutputStream(saveFile));
			} catch (Exception e) {
				e.printStackTrace();
			}
			for (Jet jet : jets) {
				pw.println(jet.getModel() + ", " + jet.getType() + ", " + jet.getSpeed() + ", " + jet.getRange() + ", " + jet.getPrice());
			}
			pw.close();
		} else {
			System.err.println("Error: file name matched orginial file name, and was not saved.");
		}

	}

}
