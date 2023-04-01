package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	public static void main(String[] args) {
		JetsApplication jetsApplication = new JetsApplication();
		jetsApplication.startUp();
	}

	public void startUp() {
		// call the airfield to read the file and create the jets.
		AirField airField = new AirField();
		airField.readFromFile("jets.txt");
		boolean on = true;
		while(on) {
			
			
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
}
