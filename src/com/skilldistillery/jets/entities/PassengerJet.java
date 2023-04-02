package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {

	public PassengerJet() {

	}

	public PassengerJet(String model, String name, Double speed, int range, long price) {
		super(model, name, speed, range, price);
	}

	@Override
	public void fly() {
		System.out.printf(this.getClass().getSimpleName() + ": " + ", Name: " + getName() + "\nSpeed: " + getSpeed()
				+ ", Range: " + getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));
		System.out.println(" hours.");

	}
}
