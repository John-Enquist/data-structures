

import java.util.Random;
import java.util.ArrayList;
//the deck class creates an array of cards which constitutes 2 decks
//and fills it with every possible card combination
//John Enquist project 3: crazy eights, Kristina Striegnitz
public class Deck {
	
	Card[] Deck;
	Integer nextCard;
	
	public Deck() {
		this.Deck = new Card[104];
		this.Deck = generateDeck();
		this.nextCard = -1;
	}
//this method returns a card array with every possible combination of cards in order
	public Card[] generateDeck()
	{
		int deckPosition = 0;
        String[] allSuits = {"Clubs", "Spades", "Hearts", "Diamonds"};
        for(int k = 0; k < 2; k++)
        {
            for(int i = 1; i<= 13; i++)
            {
            	for(int j = 0; j < 4; j++)
            	{
            		Card aCard = new Card(allSuits[j], i);;
            		this.Deck[deckPosition] = aCard;
            		deckPosition += 1;
            	}
            }
        }

        return this.Deck;
	}
//this method returns the list of cards inside the deck
	public void showDeck()
	{
		for(int i = 0; i < Deck.length; i++)
		{
			Card oneCard = Deck[i];
			oneCard.displayCard();
			
		}
	}
//this method will return the first card object in a deck
	public Card deal()
	{
		
		this.nextCard += 1;
		return Deck[nextCard];
		
	}
//this method shuffles the deck using a random number generator
	public void shuffle()
	{
		Random indexGenerator = new Random();
		for(int i = 0; i < 104; i++)
		{
			int cardIndex = indexGenerator.nextInt(104-i);
			Card tempCard = Deck[i];
			Card tempCard2 = Deck[cardIndex];
			this.Deck[i] = tempCard2;
			this.Deck[cardIndex] = tempCard;
		}
	}
	
}
