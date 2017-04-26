//fill this in


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
	
	/* inserts a new node in the correct spot such that all
	 * elements before toAdd are “smaller or equal” according to the compareTo method
	 * defined for typeT and all elements after toAdd are “greater or equal” according to the
	 * compareTo method defined for type T
	 * @parameter toAdd: the data to be added
	 */
	public void insertSorted(T toAdd){
		int index = 0;
		GenericListNode<T> currentNode = headNode;
		if(numInList == 0)
		{
			add(0, toAdd);
		}
		else
		{
			while(currentNode != null && currentNode.data.compareTo(toAdd) <= 0)
			{
				currentNode = currentNode.next;
				index++;
			}
			add(index, toAdd);
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
		String concatString = "";
		GenericListNode<T> currentNode = headNode;
		for(int i = 0; i < numInList; i++)
		{
			if(currentNode != headNode){
				concatString += "\n";
			}
			concatString += currentNode.data;
			currentNode = currentNode.next;
		}
		return concatString;
	}
	public int length(){
		return numInList;
	}
}
