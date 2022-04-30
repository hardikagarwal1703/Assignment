package com.app.fruits;

public class Apple extends Fruit{

	public Apple(String color, double weight, String name, boolean fresh) {
		super(color, weight, name, fresh);
		// TODO Auto-generated constructor stub
	}

	public void jam() {
		System.out.println("Name: " + super.getName() +  
					" making jam!");
	}

	@Override
	public String taste() {
		return "sweet n sour";
	}
}
