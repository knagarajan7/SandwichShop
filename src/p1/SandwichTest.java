package p1;
import p1.Sandwich;
import p1.Meal;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class SandwichTest {

	@Test
	public void test1() {  //One Signature Sandwich with combo
		ArrayList<Sandwich> Sand = new ArrayList<Sandwich>();
		ArrayList<String> toppings1 = new ArrayList<String>();
		String bread1 = "";
		String filling1 = "";
		boolean chips1 = false; 
		boolean drink1 = false;
		double price1 = 0.0;

		
		//Testing with a Signature Sandwich with combo only
		toppings1.add("Provolone Cheese");
		toppings1.add("Lettuce");
		toppings1.add("Tomato");
		toppings1.add("Mayo");
		bread1 = "Wheat";
		filling1 = "Ham";
		price1 = 7.0;
		chips1 = true;
		drink1 = true;
		price1 +=2.0;
		Sandwich s1 = new Sandwich(drink1,chips1,bread1, filling1, toppings1, price1);
		Sand.add(s1);
		//Sandwich s2 = new Sandwich();
		
		System.out.println(Meal.cost(Sand));
		assertEquals(9.0, Meal.cost(Sand), 0.0);
		//fail("Not yet implemented");
	}

	@Test
	public void test2() { //One signature Sandwich with chips and one Custom Sandwich with Combo
		ArrayList<Sandwich> Sand = new ArrayList<Sandwich>();
		
		ArrayList<String> toppings1 = new ArrayList<String>();
		String bread1 = "";
		String filling1 = "";
		boolean chips1 = false; 
		boolean drink1 = false;
		double price1 = 0.0;
		
		ArrayList<String> toppings2 = new ArrayList<String>();
		String bread2 = "";
		String filling2 = "";
		boolean chips2 = false; 
		boolean drink2 = false;
		double price2 = 0.0;
			
		//Test with one Signature Sandwich (With only Chips)
		toppings1.add("Provolone Cheese");
		toppings1.add("Lettuce");
		toppings1.add("Tomato");
		toppings1.add("Mayo");
		bread1 = "Wheat";
		filling1 = "Ham";
		price1 = 7.0;
		chips1 = true;
		drink1 = false;
		price1 +=1.5;
		Sandwich s1 = new Sandwich(drink1,chips1,bread1, filling1, toppings1, price1);
		Sand.add(s1);
		
		// Test with one Custom Sandwich (With combo)
		toppings2.add("Provolone Cheese");
		toppings2.add("Lettuce");
		toppings2.add("Olives");
		toppings2.add("Green Peppers");
		toppings2.add("Mustard");
		bread2 = "Flat Bread";
		filling2 = "Turkey";
		price2 = 6.0;
		chips2 = true;
		drink2 = true;
		price2 +=2.0;
		
		Sandwich s2 = new Sandwich(drink2,chips2,bread2, filling2, toppings2, price2);
		Sand.add(s2);
		
		System.out.println(Meal.cost(Sand));
		assertEquals(16.5, Meal.cost(Sand), 0.0);
		//fail("Not yet implemented");
	}
	
	@Test
	public void test3() {
		ArrayList<Sandwich> Sand = new ArrayList<Sandwich>();
		System.out.println(Meal.cost(Sand));
		assertEquals(0.0, Meal.cost(Sand), 0.0);

	}
}
