/**
 * This Class is used to create items to be bought or sold We simply have a name code and price 
 * with various getter and setter methods to get private information for cashRegister
 * @author Brendan Breuss
 *
 */
public class Item {
	/**	Stores the created items itemCode to be used for purchases*/
	private int itemCode;
	/**	Stores the created items itemName to be used for purchases*/
	private String itemName;
	/**	Stores the created items itemPrice to be used for purchases*/
	private double itemPrice;
	
	/**
	 * Default Item Constructor to set values to 0 or empty string
	 */
	public Item() {
		this.itemCode = 0;
		this.itemName = "";
		this.itemPrice = 0.0;
	}
	
	/**	
	 * Item Constructor that takes input to create an item with specified values
	 * @param itemCode	The items itemcode used to uniquely identify it
	 * @param itemName	The items itemName that is the name of the current item
	 * @param itemPrice	The price that we want the item to have
	 */
	public Item(int itemCode, String itemName, double itemPrice) {
		/*Below we set the current items code, name and price to be the inputted values */
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;			
	}
	
	/**
	 * Getter for the Items itemCode
	 * @return gives us the Items itemCode
	 */
	public int getItemCode() {
		return itemCode;
	}
	
	/**
	 * Getter for the Items ItemName
	 * @return	Gives us the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Getter for Items current price
	 * @return we get the items price
	 */
	public double getitemPrice() {
		return itemPrice;
	}
	
	
}
