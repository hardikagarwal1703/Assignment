package com.app.fruits;

public class Orange extends Fruit{
	
	public Orange(String color, double weight, String name, boolean fresh) {
		super(color, weight, name, fresh);
		// TODO Auto-generated constructor stub
	}
	
	public void juice() {
		System.out.println("Name: " + super.getName() + 
				" Weight: " + super.getWeight() + 
					" extracting juice!");
	}

	@Override
	public String taste() {
		return "sour";
	}
}
