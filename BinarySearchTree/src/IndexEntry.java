/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */

public class IndexEntry implements Comparable<IndexEntry>{

	String word;
	GenericLinkedList<Integer> pages;
	public IndexEntry() {
		word = null;
		pages = new GenericLinkedList<Integer>();
	}
	
	/*
	 * this method checks to see if the index entry has 4 page numbers
	 * in the list. returns true iff full
	 */
	public boolean isFull(){
		if(pages.size() > 3){
			return true;
		}
		return false;
	}
	
	/*
	 * returns the indexed word
	 */
	public String getWord(){
		return word;
	}
	
	/*
	 * sets the value of word to a given word
	 * @param aWord: the value to set equal to word
	 */
	public void setWord(String aWord){
		word = aWord;
	}
	
	/*
	 * adds a page number to the index iff the index is not full,
	 * and the page number is not already in the index.
	 * @parameter page: the page number to add.
	 */
	public void addPages(int page){
		if(!isFull());
		{
			if(pages.find(page) == null)
			{
				pages.addAtTail(page);
			}
		}


	}

	/*
	 *returns a string representation of the IndexEntry 
	 */
	public String toString(){
		return word + ": " + pages.toString();

		
	}
	/*
	 * compares this index entry to another index entry.
	 * @return a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 * @parameter otherEntry: the indexEntry to compare to
	 */
	public int compareTo(IndexEntry otherEntry){
		return getWord().compareToIgnoreCase(otherEntry.getWord());
	}



}
