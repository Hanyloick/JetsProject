package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	
	public PassengerJet() {
		
	}
	public PassengerJet(String model,String name, Double speed, int range, long price) {
		super(model, name, speed, range, price);
	}
	
	@Override
	public void fly() {
		System.out.println(this.toString());
	}
}
