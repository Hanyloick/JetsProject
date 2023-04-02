package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	public static void main(String[] args) {
		JetsApplication jetsApplication = new JetsApplication();
		jetsApplication.startUp(jetsApplication);
	}

	public void startUp(JetsApplication jetsApplication) {
		// call the airfield to read the file and create the jets.
		Scanner scanner = new Scanner(System.in);
		AirField airField = new AirField();
		airField.setFleet(airField.readFromFile("jets.txt"));
		boolean on = true;
		while (on) {
			jetsApplication.displayMenu();
			on = jetsApplication.userChoice(scanner, airField);

		}

	}

	public void displayMenu() {
		System.out.println("|------------------------------|");
		System.out.println("1.------List The Fleet.--------|");
		System.out.println("2.-------Fly All Jets.---------|");
		System.out.println("3.-----View Fastest Jet.-------|");
		System.out.println("4.-View Jet With Longest Range.|");
		System.out.println("5.-----Load All Cargo Jets.----|");
		System.out.println("6.--------Dogfight!------------|");
		System.out.println("7.---Add A Jet To The Fleet.---|");
		System.out.println("8.-Remove A Jet From The Fleet.|");
		System.out.println("9.----------Quit---------------|");
		System.out.println("|------------------------------|");
	}

	public boolean userChoice(Scanner scanner, AirField airField) {
		int input = 0;
		do {
			input = getIntput(scanner);
			if (input < 1 || input > 9) {
				System.out.println("Out of Range, Try Again.");
			}
		} while (input < 1 || input > 9);
		switch (input) {
		case 1:
			airField.listFleet();
			;
			break;
		case 2:
			airField.fly();
			break;
		case 3:
			airField.viewFastestJet();
			break;
		case 4:
			airField.viewLongestRange();
			break;
		case 5:
			airField.loadAllCargo();
			break;
		case 6:
			airField.dogFight();
			break;
		case 7:
			addNewJet(scanner, airField);
			break;
		case 8:
			
		case 9:
			System.out.println("Thank You!");
			return false;
		}
		return true;
	}

	public int getIntput(Scanner scanner) {

		int input = 0;
		try {
			input = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Invalid Input, Try Again.");
			scanner.nextLine();
		}
		return input;
	}

	public double getDouble(Scanner scanner) {
		double input = 0;
		try {
			input = scanner.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("Invalid Input, Try Again.");
			scanner.nextLine();
		}
		return input;
	}

	public double getLongPut(Scanner scanner) {
		long input = 0;
		try {
			input = scanner.nextLong();
		} catch (InputMismatchException e) {
			System.err.println("Invalid Input, Try Again.");
			scanner.nextLine();
		}
		return input;
	}
	
	private void addNewJet(Scanner scanner, AirField airField) {
		String model = "";
		String name = "";
		double speed = 0.0;
		int range = 0;
		long price = 0;
		int choice = 0;

		do {
			System.out.println("What type of jet would you like to add? Select the number of your choice below.");
			System.out.println("|-----------------|");
			System.out.println("1.----Passenger---|");
			System.out.println("2.-----Cargo------|");
			System.out.println("3.----Fighter-----|");
			System.out.println("|-----------------|");
				choice = getIntput(scanner);
		} while (choice != 1 && choice != 2 && choice != 3);

		switch (choice) {
		case 1:
			model = "PassengerJet";
			break;
		case 2:
			model = "CargoJet";
			break;
		case 3:
			model = "FighterJet";
			break;
		}

		do {
			System.out.println("Enter the jet name >> ");
			try {
				name = scanner.next();
				System.out.println("Enter the jet's speed >> ");
				speed = getDouble(scanner);
				System.out.println("Enter the jet's range >> ");
				range = getIntput(scanner);
				System.out.println("Enter the jet's price >> ");
				price = scanner.nextLong();

			} catch (Exception e) {
				System.err.println("\nInvalid input. Please try again.\n");
				scanner.nextLine();
				model = "";
				name = "";
				speed = 0.0;
				range = 0;
			}
		} while (model.equals("") && speed == 0.0 && range == 0 && price == 0.0);

		System.out.println("The following jet was added.");
		System.out.println(airField.addNewJet(choice, model, name, speed, range, price));

	}

	

}