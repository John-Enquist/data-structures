
import java.util.Scanner;

//john enquist project 3 crazy eights kristina striegnitz
public class CrazyEights {

	private Hand[] ALLPLAYERS;
	private Card CURRENTCARD;
	private Deck DECK;
	private boolean GAMEOVER;
	
	
	public CrazyEights() {
		this.ALLPLAYERS = new Hand[getNumPlayers()];
		this.DECK = new Deck();
		this.GAMEOVER = false;
	}
	/*
	 * this method plays the game of crazy eights
	 */
	public void PlayGame()
	{
		startGame();
		endGame();
	}
	//gets the number of players from user input using scanner
	public int getNumPlayers()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("__How_Many_Players?__");
		int players = scanner.nextInt();
		return players;	
	}
	//names the players hands using user input from scanner
	public void namePlayers()
	{
		int totalPlayers = ALLPLAYERS.length;
		for(int i=0; i< totalPlayers; i++)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("player " + i + "'s name is:");
			String name = scanner.next();
			this.ALLPLAYERS[i].setName(name);
			
		}
	}
	
	/*
	 * this method creates each players hands given the number of players
	 * and then gives 7 cards to each hand
	 */
	public void createHands(Deck deck)
	{
		int totalPlayers = ALLPLAYERS.length;
		for(int i = 0; i < totalPlayers; i++ )
		{
			Hand hand = new Hand();
			this.ALLPLAYERS[i] = hand;
			
		}
		for(int i= 0; i< totalPlayers; i++)
		{
			for(int j = 0; j<7; j++)
			{
				this.ALLPLAYERS[i].drawCard(deck);
			} 
		}
		
	}
	/* this method initializes the game process by shuffling the deck,
	 * playing the top card from the deck as current card, and making
	 * the different players. it then prints the instructions on how to play
	 */
	public void startGame()
	{
		this.DECK.shuffle();
		this.CURRENTCARD = this.DECK.deal();
		createHands(this.DECK);
		namePlayers();
		printInstructions();
	}
	/*
	 * this method represents an individual players turn, and returns true
	 * iff the player has no cards left in their hand. else returns false
	 */
	public boolean playerTurn(Hand hand)
	{
		Card cardChoice = hand.playCard(this.CURRENTCARD);
		if(cardChoice.equals(this.CURRENTCARD) == false)
		{
			if(cardChoice.getValue() == 8)
			{
				this.CURRENTCARD = crazyEights();
				System.out.println("(originally it was the " + cardChoice.toString() + ")");
			}
			else
			{
				this.CURRENTCARD = cardChoice;
			}
			if(hand.gameWon())
			{
				this.GAMEOVER = true;
				return true;
			}
		}
		else
		{
			if(emptyDeck() == false)
			{
				Scanner scanner = new Scanner(System.in);
				System.out.println("type the number of cards you wish to draw");
				int numCards = scanner.nextInt();
				drawCards(numCards, hand);
			}
			else
			{
				System.out.println("there are no cards left to draw sorry!");
			}
			
		}
		return false;
	}
	//checks to see if the deck is empty
	public boolean emptyDeck()
	{
		if(this.DECK.nextCard == 103)
		{
			System.out.println("you have emptied the deck play it out!!");
			return true;
		}
		return false;
	}
	
	public void theGame(int player)
	{
		if(ALLPLAYERS[player].gameWon() == false)
		{
			playerTurn(ALLPLAYERS[player]);
		}
		else
		{
			this.GAMEOVER = true;
		}
	}
	
	//checks to see the value of game over being true or false,
	//returns when gameover is equal to true
	public void endGame()
	{
		while(this.GAMEOVER == false)
		{
			for(int i = 0; i < this.ALLPLAYERS.length; i++)
			{
				if(this.GAMEOVER == false)
				{
					theGame(i);
				}

			}
		}
		System.out.println("you won the game!!");
		return;
	}
	//takes user input to switch an 8s suit to any other suit
	public Card crazyEights()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("##__Crazy_Eight__##");
		System.out.println("Which suit? (C, D, H, S)");
		String suit = scan.next();
		return changeSuit(suit);
	}
	//changes the cards suit if the card is an 8
	public Card changeSuit(String suit)
	{
		if(suit.equals("C"))
		{
			Card newSuit = new Card("Clubs", 8);
			return newSuit;
		}
		if(suit.equals("D"))
		{
			Card newSuit = new Card("Diamonds", 8);
			return newSuit;
		}
		if(suit.equals("H"))
		{
			Card newSuit = new Card("Hearts", 8);
			return newSuit;
		}
		if(suit.equals("S"))
		{
			Card newSuit = new Card("Spades", 8);
			return newSuit;
		}
		return null;
	}
	//prints the instructions
	public void printInstructions()
	{
		System.out.println("___Crazy_Eights___");
		System.out.println("each player is dealt 7 cards from the deck and 1 card is placed faceup on the table");
		System.out.println("the point of the game is to eliminate all the cards from your hand");
		System.out.println("in order to play a card, the user must select the number next to the cards value");
		System.out.println("you can only play a card if it matches the suit or value of the current table card");
		System.out.println("an 8 is a wild card, the suit is chosen by the user by inputting the correct character");
		System.out.println("if none of your cards match the table card, randomly pick a card from your hand to draw");
		System.out.println("this will allow you to draw as many cards as you desire, but a minimum of 1 is required");
		System.out.println("the first one to eliminate all the cards from their hand wins the game!!");
		
	}
	//given the number of cards to draw, takes that many cards from the deck
	//and gives them to the specific hand
	public void drawCards(int numCards, Hand hand)
	{
		for(int i = 0; i < numCards; i++)
		{
			hand.drawCard(this.DECK);
		}
		System.out.println("you drew " + numCards + "cards");
	}

}
