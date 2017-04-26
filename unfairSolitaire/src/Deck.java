/*
 * @author John Enquist project 2: unfair Solitaire, Kristina Striegnitz
 * @version 2 for project 2, rewritten
 * 
 * the deck class creates an array of cards which constitutes a deck 
 * and fills it with every possible card combination
 */

import java.util.Random;
public class Deck {
	
	private Card[] DECK;
	private Integer NEXTCARD;
	
	public Deck() {
		this.DECK = new Card[52];
		this.DECK = generateDeck();
		this.NEXTCARD = -1;
	}
/*this method returns a card array with every possible combination of cards in order
 * @return: the newly made deck
 */
	public Card[] generateDeck()
	{
		int deckPosition = 0;
        String[] allSuits = {"Clubs", "Spades", "Hearts", "Diamonds"};
        for(int i = 1; i<= 13; i++)
        {
        	for(int j = 0; j < 4; j++)
        	{
        		Card aCard = new Card(allSuits[j], i);;
        		this.DECK[deckPosition] = aCard;
        		deckPosition += 1;
        	}
        }
        return this.DECK;
	}
//this method returns the list of cards inside the deck
	public void showDeck()
	{
		for(int i = 0; i < DECK.length; i++)
		{
			Card oneCard = DECK[i];
			oneCard.displayCard();
			
		}
	}
//this method will return the first card object in a deck
	public Card deal()
	{
		
		this.NEXTCARD += 1;
		return DECK[NEXTCARD];
		
	}
/*
 * this method shuffles the deck using the random import tool, and swaps the indexes of
 * random cards with the deck position i 
 */
	public void shuffle()
	{
		Random indexGenerator = new Random();
		for(int i = 0; i < 52; i++)
		{
			int cardIndex = indexGenerator.nextInt(52-i);
			Card tempCard = DECK[i];
			Card tempCard2 = DECK[cardIndex];
			this.DECK[i] = tempCard2;
			this.DECK[cardIndex] = tempCard;
		}
	}
	
}
