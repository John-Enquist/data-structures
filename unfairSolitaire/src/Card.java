
/*
 * this class creates a card object with its value and suit
 * the actual set of cards are created in the deck class
 * @author John Enquist project 2: unfair Solitaire, Kristina Striegnitz
 * 
 */
public class Card {

	private String CARDSUIT;
	private int CARDVALUE;
	
	/*
	 * @parameter takes in a suit and value to generate the cards
	 */
	public Card(String suit, int value) {

		this.CARDSUIT = suit;
		this.CARDVALUE = value;
	}
	//@return a given cards suit in string form
	public String getSuit()
	{
		return CARDSUIT;
	}
	//@return a given cards value in int form
	public int getValue()
	{
		return CARDVALUE;
	}

	/*
	 * this method displays the face cards correctly instead of integers
	 * but still keeps the int value of the facecards while doing so
	 */
	public void displayCard()
	{
		if(CARDVALUE <=10)
		{
			System.out.println(CARDVALUE + " of " + CARDSUIT);
		}
		else if(CARDVALUE == 11)
		{
			System.out.println("Jack of " + CARDSUIT);
		}
		else if(CARDVALUE == 12)
		{
			System.out.println("Queen of " + CARDSUIT);
		}
		else if(CARDVALUE == 13)
		{
			System.out.println("King of " + CARDSUIT);
		}
	}
	
	/*
	 *this toString method returns a string of the cards values
	 *it is much easier to print out multiple strings than void printlns 
	 */
	public String toString()
	{
		if(CARDVALUE <=10)
		{
			return (CARDVALUE + " of " + CARDSUIT);
		}
		else if(CARDVALUE == 11)
		{
			return ("Jack of " + CARDSUIT);
		}
		else if(CARDVALUE == 12)
		{
			return ("Queen of " + CARDSUIT);
		}
		else 
		{
			return ("King of " + CARDSUIT);
		}
	}


}
