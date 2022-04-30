package com.app.customer;

public enum ServicePlan {
	SILVER(500),GOLD(1000),DIAMOND(1500),PLATINUM(2000);

	private int amount;

	private ServicePlan(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	@Override
	public String toString() {
		return name() + 
				" Registration Amount: "+ this.amount + "\n";
	}
}