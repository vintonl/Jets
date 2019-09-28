package com.skilldistillery.jets.app;

import java.util.Scanner;

public class JetsApplication {

	private AirField airField;
	private Scanner scanner = new Scanner(System.in);

	public JetsApplication() {

	}

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		String fileName = "jets.txt";

		ja.airField = new AirField(fileName);

		ja.launch();
	}

	private void launch() {
		System.out.println("Welcome to the Jet App.");
		boolean start = true;
		while (start) {
			displayUserMenu();
			start = userInput();
		}

		System.out.println("Bye.");
		System.exit(0);
	}

	private void displayUserMenu() {
		System.out.println();
		System.out.println("Menu of options:");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");

	}

	private boolean userInput() {
		System.out.println("Please enter your choice (1-9): ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		System.out.println();

		switch (choice) {
		case 1:
			airField.listFleet();
			break;
		case 2:
			airField.fly();
			break;
		case 3:
			airField.viewFastest();
			break;
		case 4:
			airField.viewLongestRange();
			break;
		case 5:
			airField.cargo();
			break;
		case 6:
			airField.dogfight();
			break;
		case 7:
			airField.addJet(scanner);
			break;
		case 8:
			airField.removeJet(scanner);
			break;
		case 9:
			return false;
		default:
			System.out.println("Invalid input. Please try again.");
			break;
		}

		return true;
	}

}
