
import java.util.Scanner;

/*this class represents the players hand, consisting of a smaller list of cards
 * than the deck. it also holds the number of cards in the hand and the
 * players name. it is used in the crazyEights game class.
 */
//john enquist project 3 crazy eights kristina striegnitz
public class Hand {
	private String PLAYERNAME;
	private Card[] HAND;
	private Integer NUMCARDS;
	
	//i initialized the card hand at 52 because your hand 
	//should never be bigger than a set of cards
	public Hand() {
		this.HAND = new Card[52];
		this.PLAYERNAME = "";
		this.NUMCARDS = 0;
	}
	
	public void setName(String name)
	{
		this.PLAYERNAME = name;
	}
	public String getName()
	{
		return this.PLAYERNAME;
	}
	//draws cards from a given deck and adds them to the hand, updates NUMCARDS
	public void drawCard(Deck deck)
	{
		this.HAND[NUMCARDS] = deck.deal();
		NUMCARDS += 1;
	}
	//returns a given card from the hand based on the slot given
	public Card chooseCard(int card)
	{
		return this.HAND[card];
	}
	//displays the players hand
	public void displayHand()
	{
		System.out.println("____________________");
		System.out.println(this.PLAYERNAME + "'s hand below");
		for(int i = 0; i < this.NUMCARDS; i++)
		{
			if(this.HAND[i] != null)
			{
				System.out.println(i + ") " + this.HAND[i].toString() );
			}
			
		}
	}
	/*
	 * this is the main method for the hand class, it first displays the hand
	 * then it will remove the card from the hand after it is played, replacing
	 * the current card on the table.
	 */
	public Card playCard(Card currentCard)
	{
		displayHand();
		System.out.println('\n' + getName() + "'s Move");
		System.out.println("__________________________________________");
		System.out.println("The top card is the " + currentCard);
		System.out.println("__________________________________________");
		System.out.println("Type the # next to the card below to select it");
		Scanner scanner = new Scanner(System.in);
		int card = scanner.nextInt();
		Card theCard = chooseCard(card);
		if(canPlay(theCard, currentCard))
		{
			removeCard(card);
			
			return theCard;
		}
		System.out.println("you cant play that card!");
		return currentCard;	
	}
	//fixes the hole left in the hand after a card is played
	public void removeCard(int card)
	{
		
		Card[] newHand = new Card[70];
		int newSlot = 0;
		this.HAND[card] = null;
		this.NUMCARDS --;
		for(int i = 0; i < this.HAND.length; i++)
		{
			if(this.HAND[i] != null )
			{
				newHand[newSlot] = this.HAND[i];
				newSlot +=1;
			}
		}
		this.HAND = newHand;
		
	}
	//checks to make sure the card being played matches either the 
	//current cards suit or value, or is an 8. returns true if it does
	public boolean canPlay(Card aCard, Card currentCard)
	{
		if(aCard.getSuit().equals(currentCard.getSuit()))
		{
			return true;
		}
		if(aCard.getValue() == currentCard.getValue())
		{
			return true;
		}
		if(aCard.getValue() == 8)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	//keeps track of whether the game is won, or if someone has 1 card left
	//returns true if the game is won
	public boolean gameWon()
	{
		for(int i = 0; i <2; i++)
		{
			if(this.HAND[i] == null)
			{
				if(i == 1)
				{
					System.out.println(getName() + " has 1 card left!!!");
				}
				if(i == 0)
				{
					return true;
				}
			}
		}
		return false;
	}
}

