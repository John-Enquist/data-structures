

//this class creates a card object with its value and suit
// the actual set of cards are created in the deck class'
//John Enquist project 3: crazy eights, Kristina Striegnitz
public class Card {

	String cardSuit;
	int cardValue;
	
	public Card(String suit, int value) {

		this.cardSuit = suit;
		this.cardValue = value;
	}
	
	public String getSuit()
	{
		return cardSuit;
	}
	public int getValue()
	{
		return cardValue;
	}
	//this method displays the face cards correctly instead of integers
	//but still keeps the int value of the facecards while doing so
	public void displayCard()
	{
		if(cardValue <=10)
		{
			System.out.println(cardValue + " of " + cardSuit);
		}
		else if(cardValue == 11)
		{
			System.out.println("Jack of " + cardSuit);
		}
		else if(cardValue == 12)
		{
			System.out.println("Queen of " + cardSuit);
		}
		else if(cardValue == 13)
		{
			System.out.println("King of " + cardSuit);
		}
	}
	
	//this toString method returns a string of the cards values
	//it is much easier to print out multiple strings than void printlns
	public String toString()
	{
		if(cardValue <=10)
		{
			return (cardValue + " of " + cardSuit);
		}
		else if(cardValue == 11)
		{
			return ("Jack of " + cardSuit);
		}
		else if(cardValue == 12)
		{
			return ("Queen of " + cardSuit);
		}
		else 
		{
			return ("King of " + cardSuit);
		}
	}

}
