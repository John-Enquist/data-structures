/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */

public class Index {
	BinarySearchTree<IndexEntry> index;
	BinarySearchTree<String> dictionary;
	int pageNumber;

	public Index() {

		index = new BinarySearchTree<IndexEntry>();
		dictionary = new BinarySearchTree<String>();
	}
	
	/*
	 * sorts a text file by putting words in index and dictionary
	 * finishes when there are no remaining words in the file, then 
	 * prints out both the dictionary and index.
	 * @parameter filename: the filename to process
	 */
	public void createIndex(String filename){
		int pageNumber = 1;
		FileReader reader = new FileReader(filename);
		String word = reader.nextToken();
		while(word != null)
		{
			word = word.replace(".", "");
			if(word.equals("#")){
				pageNumber++;
			}
			else{
				if(word.length() > 2 && dictionary.find(word) == null)
				{
					IndexEntry theWord = new IndexEntry();
					theWord.setWord(word);
					if(index.find(theWord) != null){ // word is in index
						IndexEntry currentEntry = index.find(theWord);
						if(currentEntry.isFull() == false){
							currentEntry.addPages(pageNumber); //adds page # if not in pages already
						}
						else{
							System.out.println(index.remove(currentEntry)); // remove from index
							dictionary.add(word); // adds to dictionary
						}	
					}
					else{ //word isn't in index yet
						index.add(theWord);
						theWord.addPages(pageNumber);
					}
				}
			}
			word = reader.nextToken();
		}
		System.out.println("***Index of Text***: \n" + index.toString() + "\n" + "***Dictionary of Text***:\n" + dictionary.toString());
	}
}
