
/*
 * @author John Enquist project 2: unfair Solitaire, Kristina Striegnitz
 * this constructor initializes the variables for the face up cards array
 * the amount of cards left, and the current cards face up in the game 
 */
public class SolitaireSimulator {

	private Card[] FACEUPCARDS;
	private int NUMOFACTIVECARDS;
	private int CARDSLEFT;


	public SolitaireSimulator() {
		this.FACEUPCARDS = new Card[52];
		this.CARDSLEFT = 52;
		this.NUMOFACTIVECARDS = 0;
	}

	/*
	 * this playgame method plays the solitaire game with set rules and
	 * @return: true iff every card is eliminated from the game, false if game was not won.
	 */
	public boolean playGame()
	{
		Deck deck = new Deck();
		beginGame(deck);
		for(int i = 0; i < 49; i ++)
		{
			dealCard(deck);
			String firstCardSuit = this.FACEUPCARDS[NUMOFACTIVECARDS-1].getSuit();
			if(NUMOFACTIVECARDS >4 && otherMatchType(firstCardSuit) || fourSuitsMatch(firstCardSuit))
			{
				eliminatingCards(firstCardSuit);
			}
		}
		if(NUMOFACTIVECARDS != 0)
		{
			return false;
		}
		return true;
	}
	/*
	 *@parameter: a given deck
	 * this method sets up several things necessary for the game to begin, including 
	 * shuffling the deck, the initial faceup cards, the number of active cards,
	 * and the number of cards left in the deck.
	 * @return this.FACUPCARDS with 4 cards starting in the array
	 */
	private Card[] beginGame(Deck theDeck)
	{
		
		theDeck.shuffle();
		for(int i = 0; i< 3; i++)
		{
			Card dealtCard = theDeck.deal();
			this.FACEUPCARDS[NUMOFACTIVECARDS] = dealtCard;
			NUMOFACTIVECARDS ++;
		}
		CARDSLEFT = CARDSLEFT - 3;
		return this.FACEUPCARDS;
	}

	/*
	 * 	this is the second of 2 rules, returning true if 4 consecutive suits
	 * match each other
	 */
	private boolean fourSuitsMatch(String firstCardSuit)
	{
		if(NUMOFACTIVECARDS >=4)
		{
			if((FACEUPCARDS[NUMOFACTIVECARDS-2].getSuit() == firstCardSuit &&
					FACEUPCARDS[NUMOFACTIVECARDS-3].getSuit() == firstCardSuit &&
					FACEUPCARDS[NUMOFACTIVECARDS -4].getSuit() == firstCardSuit))
			{
				return true;
			}
		}

		return false;
	}
	/*
	 * this is the first rule for eliminating cards, this method returns
	 * true if 2 sandwiched cards are surrounded by 2 matching suits
	 * @parameter takes in the cards suit 
	 * @return true if four cards math in a row, false if they dont
	 */
	private boolean otherMatchType(String firstCardSuit)
	{
		if(FACEUPCARDS[NUMOFACTIVECARDS-4].getSuit() == firstCardSuit)
		{
			return true;
		}
	return false;
	}
	
	/*
	 *this method checks to see if either of the rules for eliminating
	 *cards apply and if so it calls helper methods to eliminate the cards
	 *while this specific method fixes the empty spaces left behind 
	 */
	public void eliminatingCards(String firstCardSuit)
	{
		if(fourSuitsMatch(firstCardSuit))
		{
			int num = 1;
			while(num != 5)
			{
				FACEUPCARDS[NUMOFACTIVECARDS - num] = null;
				num += 1;
			}
			NUMOFACTIVECARDS = (NUMOFACTIVECARDS - 4);
		}
		else if(otherMatchType(firstCardSuit))
		{
			FACEUPCARDS[NUMOFACTIVECARDS -2] = null;
			FACEUPCARDS[NUMOFACTIVECARDS -3] = null;
			FACEUPCARDS[NUMOFACTIVECARDS -3] = FACEUPCARDS[NUMOFACTIVECARDS -1];
			NUMOFACTIVECARDS = (NUMOFACTIVECARDS - 2);
		}
	}
/*
 * this method keeps track of the cards remaining to be dealt
 * as well as the current number of active cards while also
 * dealing the next card in the deck
 */
	public void dealCard(Deck deck)
	{
		if(CARDSLEFT != 0)
		{
			this.FACEUPCARDS[NUMOFACTIVECARDS] = deck.deal();
			NUMOFACTIVECARDS ++;
			CARDSLEFT --;
		}
	}
	
}
