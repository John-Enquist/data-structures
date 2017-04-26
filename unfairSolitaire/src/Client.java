/*
 * @author John Enquist project 2: unfair Solitaire, Kristina Striegnitz
 * @version 2 for project 2, rewritten
 */
public class Client {

	/*
	 * this method runs the solitaire simulator several thousand times, displaying the wins
	 * over the total times the program ran. 
	 * @return: simply prints the wins over total times the code was run.
	 */
	public static void main(String[] args)
	{
		int wins = 0;
		for(int i = 1000; i < 10000; i += 1000)
		{
			int j = 0;
			while(j != i)
			{
				SolitaireSimulator theGame = new SolitaireSimulator();
				if(theGame.playGame())
				{
					wins++;
				}
				j++;
			}
			System.out.println(wins + "/" + i);
		}	
	}
}
