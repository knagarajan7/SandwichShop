package p1;
import java.util.*;
import p1.Sandwich;
import java.io.*;
public class Meal {
    static double runningPrice = 0.0; 
	static double totalPrice = 0.0;
	static ArrayList<Sandwich> SandList = new ArrayList<Sandwich>();

	public static void main(String[] args){

		System.out.println("Welcome to the Sandwich Store");
		menu();
	}
	
	
	// PRINTING THE HOME SCREEN WITH ALL THE CHOICES
	static void printMenu(){ 
		System.out.println("Please select from one of the following: ");
		System.out.println("1. Add Signature Sandwiches");
		System.out.println("2. Add Custom Sandwiches");
		System.out.println("3. View Cart");
		System.out.println("4. Delete Item");
		System.out.println("5. Checkout");
		System.out.println("Enter any other number to cancel order and Exit");
	}
	
	
	//MAIN MENU RECEIVES INPUT FROM USER AND CALLS APPROPRIATE FUNCTION
	static void menu(){
		Scanner in = new Scanner(System.in);
		printMenu();
		
		int choice = in.nextInt();
		if(choice>6){
			System.out.println("Thank you! Please come back!");
			System.exit(0);
		}
		while(choice < 6){
		
		if (choice == 1) {
			specialty();
			printMenu();
			choice = in.nextInt();
		}
		else if (choice == 2) {
			try {
				custom();
			}
			catch(Exception e) {
				System.err.print(e);
			}
			printMenu();
			choice = in.nextInt();
		}
		else if (choice == 3) {
			printOrder(SandList);
			printMenu();
			choice = in.nextInt();
		}
		else if (choice == 4) {
			modify(SandList);
			printMenu();
			choice = in.nextInt();
		}

		else if (choice == 5) {
			checkout();
			printMenu();
			choice = in.nextInt();
		}
		else {
			System.out.println("Invalid Choice. Please select again. ");
			printMenu();
			choice = in.nextInt();}
		}
	}
	
	
	
	
	
	
	//FUNCTION TO CHOOSE FROM ONE OF THE SIGNATURE SANDWICHES OF THE RESTAURANT
	static void specialty(){
		Scanner in = new Scanner(System.in);
		ArrayList<String> toppings = new ArrayList<String>();
		String bread = "";
		String filling = "";
		double price = 0.0;
		boolean chips = false;
		boolean drink = false;
		System.out.println("Please select from a list of Signature Sandwiches");
		System.out.println("1. Ham Sub (Wheat Bread, Ham, Provolone Cheese, Lettuce, Tomato & Mayo) : $7.0");
		System.out.println("2. Tuna Sub (Five Grain, Tuna, Pepperjack, Lettuce, Tomato, Onion & Chipotle) : $6.5");
		System.out.println("3. Turkey Sub (White Bread, Turkey, American Cheese, Lettuce, Cucumber & Mayo) : $8.0");
		System.out.println("4. Veggie Sub (Flat Bread, Avacado, Provolone Cheese, Lettuce, Onions, Cucumber, Tomato & Mayo) : $6.0");
		int choice = in.nextInt();
		
		switch(choice){
		case 1: 
			toppings.add("Provolone Cheese");
			toppings.add("Lettuce");
			toppings.add("Tomato");
			toppings.add("Mayo");
			bread = "Wheat";
			filling = "Ham";
			runningPrice += 7.0;
			price = 7.0;
			break;
		case 2:
			toppings.add("PepperJack");
			toppings.add("Lettuce");
			toppings.add("Tomato");
			toppings.add("Onion");
			toppings.add("Chipotle");
			bread = "Five Grain";
			filling = "Tuna";
			runningPrice += 6.5;
			price = 6.5;
			break;
		case 3: 
			toppings.add("American Cheese");
			toppings.add("Lettuce");
			toppings.add("Cucumber");
			toppings.add("Mayo");
			bread = "Herbs and Cheese";
			filling = "Turkey";
			runningPrice += 8.0;
			price = 8.0;
			break;
		case 4: 
			toppings.add("Cucumber");
			toppings.add("Provolone Cheese");
			toppings.add("Lettuce");
			toppings.add("Onions");
			toppings.add("Tomato");
			toppings.add("Mayo");
			bread = "Flat Bread";
			filling = "Avacado";
			runningPrice += 6.0;
			price = 6.0;
			break;
		default: 
			System.out.println("Invalid Choice. Please select again. ");
			break;
		}
		
		
		//OFFERING COMBO OR EXTRA ITEMS INDIVIDUALLY
		System.out.println("Please select from the following options");
		System.out.println("1. Chips - $1.50");
		System.out.println("2. Drinks - $1.50");
		System.out.println("3. Combo (Chips+Drink) - $2.00");
		System.out.println("4. No extras");
		int choice2 = in.nextInt();
		
		if(choice2 == 1){
			chips = true;
			runningPrice+=1.5;
			price+=1.5;
		}
		else if(choice2 == 2){
			drink = true;
			runningPrice+=1.5;
			price+=1.5;
		}
		else if(choice2 == 3){
			chips = true;
			drink = true;
			runningPrice+=2;
			price+=2.0;
		}
		else if(choice2 == 4){
			
		}
		else{
			System.out.println("Invalid choice. Please choose again");
			choice2 = in.nextInt();
		}
		
		
		
		Sandwich mySand = new Sandwich(drink, chips, bread, filling, toppings, price);
		SandList.add(mySand);
		printOrder(SandList);
		System.out.println("Current Sub Total: $" + runningPrice);
		
	}
	
	
	
	
	
	//FUNCTION TO CUSTOMIZE YOUR OWN SANDWICH
	static void custom() throws Exception{
		ArrayList<String> toppings = new ArrayList<String>();
		String bread = "";
		String filling = "";
		boolean chips = false;
		boolean drink = false;
		double price = 0.0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please select from a list of Breads");
		System.out.println("1. White Sub");
		System.out.println("2. Wheat Sub");
		System.out.println("3. Five Grain Sub");
		System.out.println("4. Flat Bread");
		int choice = Integer.parseInt(br.readLine());
		if(choice ==1){
			bread ="White Sub";
		}
		else if(choice == 2){
			bread = "Wheat Sub";
		}
		else if(choice ==3){
			bread = "Five Grain Sub";
		}
		else if(choice ==4){
			bread = "Flat Bread";
		}
		else{
			System.out.println("Invalid choice. Please choose again");
			choice = Integer.parseInt(br.readLine());

		}
		
		System.out.println("Please select from a Main Filling");
		System.out.println("1. Ham");
		System.out.println("2. Turkey");
		System.out.println("3. Tuna");
		System.out.println("4. Avocado");
		System.out.println("5. Chicken");
		System.out.println("6. Egg");
		System.out.println("7. Beef");
		int choice2 = Integer.parseInt(br.readLine());
		
		if(choice2 == 1){
			filling ="Ham";
			runningPrice += 7.0;
			price+=7.0;
		}
		else if(choice2 == 2){
			filling = "Turkey";
			runningPrice += 6.0;
			price+=6.0;
		}
		else if(choice2 == 3){
			filling = "Tuna";
			runningPrice += 7.0;
			price+=7.0;
		}
		else if(choice2 == 4){
			filling = "Avocado";
			runningPrice += 6.5;
			price+=6.5;
		}
		else if(choice2 == 5){
			filling ="Chicken";
			runningPrice += 7.5;
			price+=7.5;
		}
		else if(choice2 == 6){
			filling = "Egg";
			runningPrice += 6.0;
			price+=7.0;
		}
		else if(choice2 == 7){
			filling = "Beef";
			runningPrice += 8.5;
			price+=8.5;
		}
		else{
			System.out.println("Invalid choice. Please choose again");
			choice2 = Integer.parseInt(br.readLine());
		}
		
		
		
		
		//REQUEST THE USER TO ENTER ALL THE TOPPINGS NEEDED
		
		System.out.println("Please enter the toppings & Condiments you want separated by a space");
		System.out.println("Lettuce");
		System.out.println("Tomato");
		System.out.println("Olives");
		System.out.println("Onions");
		System.out.println("Green Peppers");
		System.out.println("Jalapenos");
		System.out.println("Pickles");
		System.out.println("Mustard");
		System.out.println("Ketchup");
		System.out.println("Chipotle");
		System.out.println("Sriracha");
		
		String Line = br.readLine();
		String[] Tops = Line.split(" ");
		for(String t: Tops){
			toppings.add(t);
		}
		
		
		
		
		//OFFER COMBO OR EXTRA ITEMS INDIVIDUALLY
		System.out.println("Please select from the following options");
		System.out.println("1. Chips - $1.50");
		System.out.println("2. Drinks - $1.50");
		System.out.println("3. Combo (Chips+Drink) - $2.00");
		System.out.println("4. No extras");
		int choice3 =  Integer.parseInt(br.readLine());
		
		if(choice3 == 1){
			chips = true;
			runningPrice+=1.5;
			price+=1.5;
		}
		else if(choice3 == 2){
			drink = true;
			runningPrice+=1.5;
			price+=1.5;
		}
		else if(choice3 == 3){
			chips = true;
			drink = true;
			runningPrice+=2;
			price+=2.0;
		}
		else if(choice3 == 4){
			
		}
		else{
			System.out.println("Invalid choice. Please choose again");
			choice3 = Integer.parseInt(br.readLine());

		}

		Sandwich mySand = new Sandwich(drink, chips, bread, filling, toppings, price);
		SandList.add(mySand);
		printOrder(SandList);
		
		System.out.println("Current Sub Total: $" + runningPrice);
		System.out.println("");
		
		
	}
	

	
	
	//FUNCTION TO PROVIDE THE TOTAL PRICE AND PRINT A BILL OF ALL ITEMS ORDERED
	static void checkout(){
		Scanner in = new Scanner(System.in);
		printOrder(SandList);
		System.out.printf("Current Sub Total: $%.2f", cost(SandList));
		System.out.println("");
		double tax = cost(SandList)*0.08;
		System.out.printf("Tax: $%.2f", tax);
		System.out.println("");
		totalPrice = cost(SandList) + tax;
		System.out.printf("Total Amount Due: $%.2f", totalPrice);
		System.out.println("");
		System.out.println("Please enter '1' to complete order or anyother number to go back to the main menu");
		int choice = in.nextInt();
		if(choice == 1){
			System.out.println("Thank you for your order!");
			System.exit(0);
		}
		else {
			System.out.println("");
		}

		
	}
	
	
	//FUNCTION TO CALCULATE SUM COST OF ALL ITEMS IN THE CART
	static double cost(ArrayList<Sandwich> SandList){
		double sum = 0.0;
		for(Sandwich s: SandList){
			sum += s.price;
		}
		return sum;
	}
	
	//FUNCION TO DELETE AN ITEM FROM CART
	static void modify(ArrayList<Sandwich> SandList){
		if(!SandList.isEmpty()){
		System.out.println("Please select the Index number of the item you want to delete:");
		printOrder(SandList);
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();
		
		SandList.remove(index-1);
		System.out.println("Item removed");
		}
		else 
			System.out.println("No Items in Cart! Please add some");
	}
	
	
	
	//FUNCTION TO DISPAY ALL ITEMS ON THE CART
	static void printOrder(ArrayList<Sandwich> SandList){
		int index = 1;
		for(Sandwich s: SandList){
			System.out.println("Item Number: " + index);
			System.out.println("Bread: " + s.bread);
			System.out.println("Filling:" + s.filling);
			System.out.print("Toppings: ");
			for(String t: s.toppings){
				System.out.print(t + " ");
			}
			System.out.println("");
			
			System.out.println("Chips:" + s.chips);
			System.out.println("Drink:" + s.drink);
			System.out.printf("Item Price $%.2f", s.price);
			System.out.println("");
			System.out.println("");
			index++;		
		}	
	}

}
