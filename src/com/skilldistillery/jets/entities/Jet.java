package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	protected String model;
	protected String name;
	protected double speed;
	protected int range;
	protected long price;
	protected double flightTime = range / speed;

	protected Jet() {

	}

	protected Jet(String model, String name, double speed, int range, long price) {
		super();
		this.model = model;
		this.name = name;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	abstract void fly();

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, name, price, range, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Jet)) {
			return false;
		}
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && Objects.equals(name, other.name) && price == other.price
				&& range == other.range && Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + "name: " + name + ", Speed: " + speed + "\n\tPrice: " + price
				+ ", Range: " + range;

	}

}
