/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */


public class GenericLinkedList<T extends Comparable<T>> {

	private GenericListNode<T> headNode;
	private int numInList;
	
	//default constructor
	public GenericLinkedList() {

		headNode = null;
		numInList = 0;
		
	}
	/*
	 * inserts a new node containing the data toAdd at the given index.
	 * @parameter index: the index to insert at
	 * @parameter toAdd: the data to add
	 */
	public void add(int index, T toAdd){
		if(index < 0)
		{
			throw new NullPointerException("thats negative yo");
		}
		GenericListNode<T> newNode = new GenericListNode<T>(toAdd);
		GenericListNode<T> currentNode = headNode;
		if(index == 0)
		{
			if(numInList == 0)
			{
				headNode = newNode;
			}
			else
			{
				newNode.next = headNode;
				headNode = newNode;
			}
		}
		else if(index > 0)
		{
			for(int i = 0; i< index -1; i++)
			{
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;	
		}
		numInList++;
	}
	
	/*
	 * adds a new node at the end of the linked list. if no nodes exist,
	 * the new node becomes the head node
	 * @parameter toAdd: the node to add to the linked list
	 */
	public void addAtTail(T toAdd){
		GenericListNode<T> newNode = new GenericListNode<T>(toAdd);
		GenericListNode<T> currentNode = headNode;
		if(size() == 0)
		{
			headNode = newNode;
			numInList++;
			return;
		}
		else
		{
			for(int i = 0; i< size() -1; i++){
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
			numInList++;
		}
		
	}
	

	/*
	 * finds the first node whose data match toRemove
	 * (according to the compareTo method), removes that node, and returns the data.
	 * @parameter toRemove: the T to be removed
	 */
	public T remove(T toRemove){
		
		GenericListNode<T> currentNode = headNode;
		GenericListNode<T> previousNode = currentNode;
		if (currentNode.data.compareTo(toRemove) == 0){
			headNode = currentNode.next;
			numInList--;
			return currentNode.data;
			
		}else{
			while (currentNode.data.compareTo(toRemove) != 0 && currentNode.data != null){
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			GenericListNode<T> removed = currentNode;
			currentNode = currentNode.next;
			previousNode.next = previousNode.next.next;
			numInList--;
			return removed.data;
		}
		
	}
	
	/*
	 *  finds the first node whose data match toFind (according to the
	 *  compareTo method), and returns the data.
	 *  @parameter toFind: the T to find in the list
	 */
	public T find(T toFind){
		GenericListNode<T> currentNode = headNode;
		if(currentNode == null)
		{
			return null;
		}
		else
		{
			while(currentNode != null && currentNode.data.compareTo(toFind) != 0)
			{
				currentNode = currentNode.next;
			}
			if(currentNode == null)
			{
				return null;
			}
			return currentNode.data;
			
		}
		
	}
	
	/*
	 * outputs the node data with a line break after each node.
	 * 
	 */
	public String toString(){
		String concatString = "{";
		GenericListNode<T> currentNode = headNode;
		if(currentNode == null){
			concatString += "}";
		}
		for(int i = 0; i < numInList; i++)
		{
			if(i == numInList-1){
				concatString += currentNode.data + "}";
			}
			else{
				concatString += currentNode.data + ", ";
				currentNode = currentNode.next;
			}
			
		}
		return concatString;
	}
	
	public int size(){
		return numInList;
	}
}
