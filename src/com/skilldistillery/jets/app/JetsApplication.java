package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
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

		ja.launch(fileName);
	}

	private void launch(String fileName) {
		System.out.println("Welcome to the Jet App.");
		boolean start = true;
		while (start) {
			displayUserMenu();
			start = userInput(fileName);
		}

		System.out.println("Thanks, and have a great one!");
		System.exit(0);
	}

	private void displayUserMenu() {
		System.out.println();
		System.out.println("Menu of options:");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View the fastest jet");
		System.out.println("4. View jet with the longest range");
		System.out.println("5. Load all the Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Save Fleet");
		System.out.println("10. Quit");
	}

	private boolean userInput(String fileName) {
		int choice = 0;
		System.out.println("Please enter your choice (1-9): ");
		try {
			choice = scanner.nextInt();
		} catch (InputMismatchException e) {
			choice = 0;
		}
		scanner.nextLine();
		System.out.println();

		switch (choice) {
		case 1:
			airField.listFleet();
			break;
		case 2:
			airField.flyJets();
			break;
		case 3:
			airField.viewFastest();
			break;
		case 4:
			airField.viewLongestRange();
			break;
		case 5:
			airField.loadCargoJets();
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
			airField.save(fileName);
			break;
		case 10:
			return false;
		default:
			System.err.println("Invalid input. Please try again.");
			break;
		}

		return true;
	}
}
