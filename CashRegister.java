// Homework 1: CashRegister Program
// Course: CIS357
// Due date: 07/05/2022
// Name: Brendan Breuss
// Instructor: Il-Hyung Cho 
// Program description: A simple CashRegister program that reads items from a file to create a mock POS system
//						we then take user input allowing them to make item selections, purchase items and 
//						receive change once the sale has been completed. Also tally's total sales for the day

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Brendan Breuss
 * 
 * The CashRegister class acts as our main class used to run our program as it only contains main. 
 * It uses both the Item and Sale class in order to act as a simple POS system.
 * It contains all required variables and methods needed to act as a functioning cash register within its main method
 * 
 * 
 * 
 */
public class CashRegister {
	/**	
	 * This is our main method which contains all of the logic and variables used in the cashRegister program
	 * Since all variables are simply used locally they were defined within the main method
	 * @param args This is simply our command Line arguments
	 */
	public static void main(String[] args) {
		String dataPath = "E:/Linux Bits/CIS357_Homework1_Items.txt";//used to determine location of items textfile on computer 
		String currentItemName = "";	              //will hold value of the current item user is trying to buy
		String startSaleInput = "";					 //will take user input to determine if they would like to start a sale or not
		boolean finishedWithSale = false;			//flag used to loop through continuing sales or stop sales 
		boolean correctTenderedAmount = false;		//flag used to ensure customer pays what they owe for item
		double subtotal = 0.0;						//variable that holds value of current subtotal
		double totalWithTax = 0.0;					//used to hold total with tax value
		double totalSoldForDay= 0.0;				//Used to increment total sales for that day
		double tenderedAmount = 0.0;				//Variable to take user money when paying for item
		double change = 0.0;						//This will store the value of change to be given to customer
		double currentItemPrice = 0.0;				//Holds the price value of the Item the user is trying to buy 
		double currentItemTotal = 0.0;				//Holds the total value of the Item the user is trying to buy
		double salesPreviouSalesTotalinArray = 0.0; //Used to manipulate total value in sales array
		int salesPreviousQuantityinArray = 0;		//Variable to change quantity in sales array
		int enterQuantityofCurrentItem = 0;			//Chooses quantity of the item user wants
		int itemCount = getItemCount();				//Assigns itemcount to be returned count of getItemCount method
		int productCode;							//Used as user input for item code they would like to buy
		Item []ItemsArray = new Item[itemCount];	//Creates Items array with the amount of items in file
		Sale []SalesArray = new Sale[itemCount];	//Creates sale array with same number as above. Can only sell what you have
		
		/*This begins our try block to read datapath as could throw filenotFound exception*/
		try {
			Scanner dataReader = new Scanner(new File(dataPath)); //Creates scanner to read through our file
			String line = dataReader.nextLine();				 // line gets the value of each new line in the file
			int i =0;											//Used to create items dynamically in array
			while(dataReader.hasNextLine()) {					//While loop checking that scanner has a line to read
			String [] Items = line.split(",");					//Creates a string array that holds values of line
			Item newItem = createItem(Items);					//Creates Item based on information on the array Items
			ItemsArray[i] = newItem;							//Dynamically fills ItemsArray with new Items in file
			i ++;												//increments i to move in ItemsArray
			line = dataReader.nextLine();						//Change the line to be the next line in file
			if (line == "") {									//Breaks out of loop if we have an empty line
				break;	
				}	
			} 												    //end while (dataReader.hasNextLine())
			dataReader.close();									//Closes our scanner we wont need it anymore
			Scanner userInput = new Scanner(System.in);			//Creates a new scanner for userinput from keyboard
			System.out.println("Welcome to Brendan's cash Register System!");
			
			while(!finishedWithSale) {							//Begins a while loop ensuring user is not done with sale
			boolean endProductCode = false;						
			boolean endQuantity = false;						//We reset all flags to ensure we move through sale steps properly
			correctTenderedAmount = false;
			for(int resetSalesArray = 0; resetSalesArray < SalesArray.length; resetSalesArray++) {
				SalesArray[resetSalesArray] = null;	//This for loop resets the Sales array back to null since new sale started
			}
			subtotal = 0;
			totalWithTax = 0; 									//Ensures that both totals are reset prior to new sale
			System.out.print("Beginning a new sale (Y/N) ");
			startSaleInput = userInput.next();					//Takes userinput from keyboard to see if they want sale
			
			if(startSaleInput.equals("N") || startSaleInput.equals("n")) {
				finishedWithSale = true;						//Checks to see if user doesnt want sale if so change flag to break from loop
			}else if(startSaleInput.equals("Y") || startSaleInput.equals("y")) { //If we are here user wants sale
				System.out.println("--------------------");
				System.out.println("Starting Sale");
				
				while(!endProductCode) {						//This checks to see if -1 is input for the productcode
					/* Try block because user could possibly not enter an integer */
					try {
					endQuantity = false;						//Resets the flag to false in case it were true
					System.out.print("Enter product code: ");
					productCode = userInput.nextInt();			//Product code is now the userinput
					if(productCode >= 11 || productCode == 0 || productCode < -1) {
						System.out.println("!!! Invalid product code");
						/*This if statement ensures correct input changes flag to get back to the current loop
						 *as we have nested while loops
						*/
						endQuantity = true;						
					}else {	
					/*Begins else which is switch case getting information from Items array using
					 * getter methods from our Items class and store them in variables from above
					*/								
					switch(productCode) {
						case 1:
							currentItemName = ItemsArray[0].getItemName();
							currentItemPrice = ItemsArray[0].getitemPrice();
							break;
						case 2:
							currentItemName = ItemsArray[1].getItemName();
							currentItemPrice = ItemsArray[1].getitemPrice();
							break;
						case 3:
							currentItemName = ItemsArray[2].getItemName();
							currentItemPrice = ItemsArray[2].getitemPrice();
							break;
						case 4:
							currentItemName = ItemsArray[3].getItemName();
							currentItemPrice = ItemsArray[3].getitemPrice();
							break;
						case 5:
							currentItemName = ItemsArray[4].getItemName();
							currentItemPrice = ItemsArray[4].getitemPrice();
							break;
						case 6:
							currentItemName = ItemsArray[5].getItemName();
							currentItemPrice = ItemsArray[5].getitemPrice();
							break;
						case 7:
							currentItemName = ItemsArray[6].getItemName();
							currentItemPrice = ItemsArray[6].getitemPrice();
							break;
						case 8:
							currentItemName = ItemsArray[7].getItemName();
							currentItemPrice = ItemsArray[7].getitemPrice();
							break;
						case 9:
							currentItemName = ItemsArray[8].getItemName();
							currentItemPrice = ItemsArray[8].getitemPrice();
							break;
						case 10:
							currentItemName = ItemsArray[9].getItemName();
							currentItemPrice = ItemsArray[9].getitemPrice();
							break;
						case -1:						//If we are at this case then we want to end current sale loop
							endProductCode = true;
							break;
						default:
							break;
					}
					if(productCode == -1) {				//Breaks us out of endProductCode loop since -1 means stop				
						break;
					}
				}
				while(!endQuantity) {					//Nested loop to get quantity of item to buy
					enterQuantityofCurrentItem = 0;		//Resets the variable back to zero
				/*User could not input integer so put in try catch */
				try {
					if (enterQuantityofCurrentItem>= 0) {	//Print the item name if our quantity entered is 0 or more
						System.out.printf("%20s %n", "         item name:" +currentItemName);
						}
					System.out.print("Enter Quantity:     ");
					enterQuantityofCurrentItem = userInput.nextInt(); //Takes userspecified quantity desired
					if(enterQuantityofCurrentItem <=0) { 			  //Makes sure we have correct quantity entered
						System.out.println("!!! Invalid quantity");
					}else {
					endQuantity = true;								//Set flag to true to escape loop
					//Sets currentItemtotal using Method defined to do so
					currentItemTotal = currentItemTotalMethod(enterQuantityofCurrentItem, currentItemPrice);
					subtotal += currentItemTotal;					//Adds currentitemTotal to subtotal
					//Generates sale object for our current item we are selling
					Sale currentSale = new Sale(enterQuantityofCurrentItem, currentItemName, currentItemTotal);
					//Checks to see if our entered Item already exists in the sales array by checking for null
					if(SalesArray[productCode - 1] != null) {
						/*If the value is not null take the current values in the sales array and assign them to variables
						 * Then add that value to the new variables declared and place those new variables back into array
						 */
						salesPreviouSalesTotalinArray = SalesArray[productCode - 1].getItemTotalinSales();
						salesPreviousQuantityinArray = SalesArray[productCode - 1].getNumberQuantityofItemsinSales();
						int newSalesQuantity = salesPreviousQuantityinArray + enterQuantityofCurrentItem;
						SalesArray[productCode - 1].setNumberQuantityofItemsinSales(newSalesQuantity);
						double newSaleTotal = salesPreviouSalesTotalinArray + currentItemTotal;
						SalesArray[productCode - 1].setItemTotalinSales(newSaleTotal);
					}else {											//If we dont have instance f current item just add to array
						SalesArray[productCode - 1] = currentSale;
					}
					
					System.out.printf("        item total: $   %.2f %n", currentItemTotal);
				}
			}
				catch(Exception Invalidquantity) { 				//Catch to ensure the quantity entered is valid
					System.out.println("!!! Invalid quantity");
					//allows scanner to continue to look for input
					System.out.println();
					userInput.nextLine();						//allows scanner to continue to look for input
			}
		}
				}
				catch(Exception Invalidproductcode) { 			//Catch to ensure correct product code entered
					System.out.println("!!! Invalid product code");
					//allows scanner to continue to look for input
					userInput.nextLine();
			}
				}//end of endproductcode while loop
				System.out.println("----------------------------");
				System.out.println("Items List:");
				orderSalesbyName(SalesArray);					//Uses method to sort and print sales array
				
				totalWithTax = calculateSalesTax(subtotal);		//calculates sales tax with method stores in variable
				totalSoldForDay = totalSoldForDay + subtotal;	//Calculates total sale for day place into variable
				System.out.printf("%-19s %s %6.2f %n", "Subtotal" , "$", subtotal);
				System.out.printf("%-19s %s %6.2f %n", "Total with Tax (6%)" , "$", totalWithTax);
				System.out.print("Tendered Amount     $ ");
				while(!correctTenderedAmount) {					//Loop to ensure the amount customer pays can cover cost
				/*Try block used in case user does not input double */
				try {
					tenderedAmount = userInput.nextDouble();	//Set user input to be amount paid
					if(tenderedAmount > totalWithTax) {			//Checks to make sure payment is greater than cost
					correctTenderedAmount = true;				//if so change flag to true ending sale
					change = tenderedAmount - totalWithTax;		//The change is simply the payment minus the total
					}else {
						System.out.println("Please enter a valid amount");
					}
				}
				catch(Exception incorrectAmountTendered) { 		//Catch if user input was not a double
					System.out.println("Please enter a valid amount");
					userInput.nextLine();
				}
		}//End of correctTenderedAmount while loop
				System.out.printf("%-19s %s %6.2f %n", "Change" , "$", change);
			}//y elseif
			else {
				System.out.println("Please select y or n");	//This is else for checking if y or n was enteref
			}
		}//End finishedwithSale while loop
			System.out.printf("%-32s %6.2f %n", "The total sale for the day is  $",totalSoldForDay); 
			System.out.println("Thanks for using POST system. Goodbye.");
			
		
		} 
	catch (FileNotFoundException e) {			//Catch ensuring that the file was found
			System.out.println("No Such file Exists");
		}
	}
	
	
	/**
	 * Takes the current sales array and sorts the array alphabetically based on name of Items
	 * @param salesArray An array of Sale objects
	 */
	private static void orderSalesbyName(Sale[] salesArray) {
		//Begins loop to go through sales array
		for(int i = 0; i<salesArray.length; i++){  		
            for (int j = i+1; j<salesArray.length; j++) {		//loops through array being one ahead to compare  
            if(salesArray[i] != null && salesArray[j] != null) {//Cannot compare String with null so ignore null
            	//Uses compareTo on the name in current array position to see if one is greater than the other
               if(salesArray[i].getItemNameSales().compareTo(salesArray[j].getItemNameSales())>0 ){    
                   Sale temp = salesArray[i];  //Set temp to be the current ith sale
                   salesArray[i] = salesArray[j];  //sets the ith element to be the jth element
                   salesArray[j] = temp;  			//Moves temp into the jth element swapping places
                }  
             }  
          }
       }
		for(int loopSales = 0; loopSales < salesArray.length; loopSales++) {
			//Loops through not null Sales Objects and prints them in nice format
			if(salesArray[loopSales] != null) {
				System.out.printf("%4d %-14s", salesArray[loopSales].getNumberQuantityofItemsinSales(),salesArray[loopSales].getItemNameSales());
				System.out.printf(" %s %6.2f %n","$",salesArray[loopSales].getItemTotalinSales());
			}
		}	
	}
	
	/**
	 * This Method calculates our current item total that the user wishes to buy
	 * @param quantity	integer that is the quantity desired to buy
	 * @param itemPrice	double that is the price of a singular item 
	 * @return The total of the Current Item in regards to quantity and price
	 */
	private static double currentItemTotalMethod(int quantity, double itemPrice) {
		int quantitytoPurchase = quantity;				//Set the variable to be equal to the quantity input
		double currentItemsPrice = itemPrice;			//sets equal to itemPrice
		double currentItemTotal = (currentItemsPrice * quantitytoPurchase);	//multiply price by quantity
		return currentItemTotal;	//Return this value to be used
	}
	
	/**
	 * Simple method to calculate the sales tax of a current subtotal
	 * @param enteredCurrentSubtotal This is the users current value of subtotal
	 * @return	this is the total with tax
	 */
	private static double calculateSalesTax(double enteredCurrentSubtotal) {
		//variable to store totalwithtax by multiplying by sales tax percentage then adding back to subtotal
		double totalWithTax = (enteredCurrentSubtotal * 0.06) + enteredCurrentSubtotal; 
		return totalWithTax;	//Returb our total with tax
	}
	
	/**
	 * Creates our items via an entered array of Strings
	 * @param itemInfo	This is an entered array of Stings
	 * @return	this is an item object
	 */
	private static Item createItem(String[] itemInfo) {
		int itemCode = Integer.parseInt(itemInfo[0]);	//parse the itemcode out of the first column in array
		String itemName = itemInfo[1];					//parse the itemName out of the second column in array
		double itemPrice = Double.parseDouble(itemInfo[2]);	//parse the itemPrice out of the third column in array
		return new Item(itemCode, itemName, itemPrice);		//Returns an item object
	}
	
	/**	
	 * Simple method to count lines in input file to create arrays of correct sizes
	 * @return	the number of items aka number of lines in the file
	 */
	private static int getItemCount() {
		String dataPath = "E:/Linux Bits/CIS357_Homework1_Items.txt";	//uses same datapath as program
		int itemCount = -1;						//Initially set to -1 because of way file is formatted with commas
		/*Try block to see if file exists otherwise throw exception*/
		try {
			Scanner dataReader = new Scanner(new File(dataPath));	//New scanner to read datapath
			while (dataReader.hasNextLine()) {	//increments itemcount if line is there
				itemCount ++;
				dataReader.nextLine();		//move to next line
			}
		} catch (FileNotFoundException e) {		//Catch if file not found
			e.printStackTrace();
		}
		return itemCount;		//returns the total itemCount
	}
	
	
}
	
	


