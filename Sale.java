/**
 * This Sale class is used to generate a receipt for our cashRegisterProgram 
 * We can generate sale objects as well as get there values
 * @author Brendan Breuss
 *
 */
public class Sale {
	/**	Holds the quantity of the Item we are purchasing*/
	private int numberofItems;
	/**	Holds the name of the Item we are purchasing*/
	private String itemName ;
	/**	Holds the name of the ItemtotalPrice that we are purchasing*/
	private double itemTotal ;
	
	/**
	 * No arg constructor for sale sets the values to zero or empty string
	 */
	public Sale() {
		this.numberofItems = 0;
		this.itemName = "";
		this.itemTotal = 0;
	}
	
	/**
	 * Contructor that takes in user paramters to create a specific sale instance
	 * @param enterednumberofItems	The number of items that is being purchased
	 * @param enteredItemName		The name of the item in the Sale
	 * @param entereditemTotal		The toalvalue of the current item in sale
	 */
	public Sale(int enterednumberofItems, String enteredItemName, double entereditemTotal) {
		this.numberofItems = enterednumberofItems;		//Sets numberofItems to entered value upon creation
		this.itemName = enteredItemName;				//Sets itemName to entered value upon creation
		this.itemTotal = entereditemTotal;				//Sets itemTotal to entered value upon creation
	}
	
	/**
	 * Getter to getItemTotal from our sale object
	 * @return the total cost of the current sale of the specific item
	 */
	public double getItemTotalinSales() {
		return itemTotal;
	}
	
	/**
	 * Getter for the quantity of the items in sales
	 * @return gives us the quantity of items purchased for sale
	 */
	public int getNumberQuantityofItemsinSales() {
		return numberofItems;
	}
	
	/**
	 * Gets us the ItemName of the current sale object
	 * @return The itemName of the sale object
	 */
	public String getItemNameSales() {
		return itemName;
	}
	
	/**
	 * Setter to set the TotalPrice of Item in Sale object
	 * @param enteredItemTotal This is the entered total we now want for the object
	 */
	public void setItemTotalinSales(double enteredItemTotal) {
		itemTotal = enteredItemTotal;
	}
	
	/**
	 * Setter to set the quantity of the current Item in Sale object
	 * @param enteredNumberofItems the entered number we want for the quantity in slae object
	 */
	public void setNumberQuantityofItemsinSales(int enteredNumberofItems) {
		numberofItems = enteredNumberofItems;
	}
}
