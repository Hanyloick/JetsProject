package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements FighterInterface {

	public FighterJet(String model, String name, double speed, int range, long price) {
		super(model, name, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("so then i was like, Pew Pew Pew!");
		System.out.println(this.toString());
		
	}

	@Override
	void fly() {
		System.out.println(this.toString());
		
	}

}
