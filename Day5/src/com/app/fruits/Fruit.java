package com.app.fruits;

public class Fruit {
	private String color;
	private double weight;
	private String name;
	private boolean fresh;

	public Fruit(String color, double weight, String name, boolean fresh) {
		super();
		this.color = color;
		this.weight = weight;
		this.name = name;
		this.fresh = fresh;
	}
	
	public String taste() {
		return "";
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getFresh() {
		return this.fresh;
	}

	public void setFresh(boolean isFresh) {
		this.fresh = isFresh;
	}

	@Override
	public String toString() {
		return "Name = " + this.name + 
				" Color = " + this.color + 
					" Weight = " + this.weight;
	}
}
	
