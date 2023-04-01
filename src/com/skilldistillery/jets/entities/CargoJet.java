package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {



	public CargoJet(String model, String name, double speed, int range, long price) {
		super(model, name, speed, range, price);
	}

	@Override
	void fly() {
		System.out.println(this.toString());
		
	}

	public void loadCargo() {
		System.out.println("Throw it in the back!");
		
	}

}
