package com.app.fruits;

public class Mango extends Fruit{
	
	public Mango(String color, double weight, String name, boolean fresh) {
		super(color, weight, name, fresh);
		// TODO Auto-generated constructor stub
	}
	
	public void pulp() {
		System.out.println("Name: " + super.getName() + 
				" Color: " + super.getColor() + 
					" creating pulp!");
	}

	@Override
	public String taste() {
		return "sweet";
	}
}
