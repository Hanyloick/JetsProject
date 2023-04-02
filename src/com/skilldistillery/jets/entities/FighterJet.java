package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements FighterInterface {

	public FighterJet(String model, String name, double speed, int range, long price) {
		super(model, name, speed, range, price);
	}

	@Override
	public void fight(boolean fighting) {
		System.out.println("so then i was like, Pew Pew Pew!");
		fly();

	}

	@Override
	void fly() {
		System.out.print(this.getClass().getSimpleName() + ": " + ", Name: " + getName() + "\nSpeed: " + getSpeed()
				+ ", Range: " + getRange() + ", Flight Time: ");
		System.out.printf("%.2f", ((getRange() / getSpeed())));System.out.println(" hours.");

	}

}
