package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> fleet = new ArrayList<>();
	// populate fleet from the file

	public List<Jet> readFromFile(String fileName) {
		// read in the Various Jet Types from the file
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String aWholeJet;
			while ((aWholeJet = bufIn.readLine()) != null) {
				String[] jetDetails = aWholeJet.split(",");
				String model = jetDetails[0];
				String name = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);
				Jet jet = null;
				if (model.equals("PassengerJet")) {
					jet = new PassengerJet(model, name, speed, range, price);
				}
				if (model.equals("CargoJet")) {
					jet = new CargoJet(model, name, speed, range, price);
				}
				if (model.equals("FighterJet")) {
					jet = new FighterJet(model, name, speed, range, price);
				}

				fleet.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
//		System.out.println(fleet);
		return fleet;
	}

	public List<Jet> getFleet() {
		return this.fleet;
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	public void fly() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void listFleet() {
		System.out.println("The fleet: ");

		for (int i = 0; i < fleet.size(); i++) {
			System.out.print(i + 1 + ". " + fleet.get(i) + "\n");
		}
		System.out.println();
	}

	public void viewFastestJet() {
		Jet fastest = null;
		for (Jet jet : fleet) {
			if (fastest == null) {
				fastest = jet;
			} else if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println("Fastest: " + fastest);
	}

	public void viewLongestRange() {
		Jet longestRange = null;
		for (Jet jet : fleet) {
			if (longestRange == null) {
				longestRange = jet;
			} else if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("Longest Range: " + longestRange);
	}
	
	public void loadAllCargo() {
		for(Jet jet : fleet ){
			if(jet instanceof CargoCarrier){
				((CargoCarrier) jet).loadCargo();
			}
		}
	}
	
	public void dogFight() {
		boolean initialJet = true;
		for(Jet jet : fleet){
			if(jet instanceof FighterJet){
				((FighterJet) jet).fight(initialJet);
				initialJet = false;
			}
		}

	}
	
	
	
	public String addNewJet(int choice, String model, String name, double speed, int range, long price) {
		
		switch (choice) {
		case 1:
			Jet jet = new PassengerJet(model, name, speed, range, price);
			fleet.add(jet);
			return jet.toString();
		case 2:
			 jet = new CargoJet(model, name, speed, range, price);
			fleet.add(jet);
			return jet.toString();
		case 3:
			 jet = new FighterJet(model, name, speed, range, price);
			fleet.add(jet);
			return jet.toString();
		}

		return "Error while adding jet.";
	}
	
}

