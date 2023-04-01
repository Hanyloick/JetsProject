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
		System.out.println(fleet);
		return fleet;
	}

}
