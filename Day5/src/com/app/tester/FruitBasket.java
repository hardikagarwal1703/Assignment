/*
 * FruitBasket Application
 * @Author: Hardik-Agarwal
 * Date: 22/04/2022 
 */
package com.app.tester;

import java.util.Scanner;

import com.app.fruits.Apple;
import com.app.fruits.Fruit;
import com.app.fruits.Mango;
import com.app.fruits.Orange;

public class FruitBasket {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//Creating FruitBasket array of user-defined length
		System.out.println("Enter size of fruit basket: ");
		Fruit[] fruitBasket = new Fruit[Integer.parseInt(scan.next())];

		//Storing fruits in respective classes
		for(int i=0;i<fruitBasket.length;i++) {

			System.out.println("Choose Option\n"
					+ "1. Add Mango\n"
					+ "2. Add Orange\n"
					+ "3. Add Apple\n");
			switch(Integer.parseInt(scan.next())){

				case 1: 
						System.out.println("Enter C,W,N of Mango");

						fruitBasket[i] = new Mango(scan.next(), 
								Double.parseDouble(scan.next()), 
								scan.next(), true);

						break;
				case 2: 
						System.out.println("Enter C,W,N of Orange");

						fruitBasket[i] = new Orange(scan.next(), 
								Double.parseDouble(scan.next()), 
								scan.next(), true);

						break;
					
				case 3:
						System.out.println("Enter C,W,N of Apple");

						fruitBasket[i] = new Apple(scan.next(), 
								Double.parseDouble(scan.next()), 
								scan.next(), true);

						break;
			}
		}

		System.out.println("\nList of fruits in basket\n");

		//Printing all fruit names
		for(Fruit fruit: fruitBasket) {
			System.out.println(fruit.getName());
		}

		System.out.println("\nTo String & Taste\n");

		//Printing fruit details and taste
		for(Fruit fruit: fruitBasket) {
			System.out.println(fruit.toString());
			System.out.println(fruit.taste());
		}

		//Setting one fruit in basket as stale according to user
		while(true) {
			System.out.println("Enter index which is stale(Not Fresh): ");

			int index = Integer.parseInt(scan.next());
			if((index>=0) && 
					(index<fruitBasket.length)){

				Fruit staleFruit = fruitBasket[index];
				staleFruit.setFresh(false);
				System.out.println("Updated Fruit" + 
						staleFruit.toString() 
							+ " Fresh: " + 
									staleFruit.getFresh());
				break;

			}else {
				System.out.println("Invalid Index");
			}
		}

		System.out.println("\nStailing all sour fruits\n");
		//Setting all sour fruits i.e. Apples & Orange as not fresh i.e. stale
		for(Fruit sourFruit: fruitBasket) {
			if((sourFruit instanceof Apple) || (sourFruit instanceof Orange)) {
				sourFruit.setFresh(false);
			}
		}

		for(Fruit sourFruit: fruitBasket) {
			if((sourFruit instanceof Apple) || (sourFruit instanceof Orange)) {
				System.out.println("Updated Fruit" + 
						sourFruit.toString() 
							+ " Fresh: " + 
								sourFruit.getFresh());
			}
		}
		
		//Invoking fruit specific functionality
		System.out.println("\nInvoking fruit specific functionality"
				+ "\nEnter Fruit Index for Specific Functionality");
		Fruit fruitFunction = fruitBasket[Integer.parseInt(scan.next())];
		
		if( fruitFunction instanceof Mango) {
			((Mango) fruitFunction).pulp();
		}else if (fruitFunction instanceof Orange) {
			((Orange)fruitFunction).juice();
		}else {
			((Apple)fruitFunction).jam();
		}

		scan.close();
	}

}
