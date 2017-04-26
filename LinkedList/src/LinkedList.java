/*
 * John Enquist project 6 Kristina Striegnitz 
 * last edited 2/18/15
 * 
 */


public class LinkedList 
{
	/*
	 * headNode is the first node in the linked list, 
	 * numInList is the size
	 */
	private ListNode headNode;
	private int numInList;
	
	/*
	 * default constructor
	 */
	public  LinkedList()
	{

		headNode = null;
		numInList = 0;
	}
	/*
	 * sets first node to an already existing node
	 * @param a complete node
	 */
	public LinkedList(ListNode aNode)
	{
		headNode = aNode;
		
	}
	/*
	 * returns the length of the linked list
	 */
	public int size()
	{
		return numInList;
	}
	
	/*
	 * this method gets the node value at a given index
	 * @param the index in storage to find the correct link
	 */
	public String get(int index)
	{
		ListNode currentNode = headNode;
		for(int i =0; i < index; i++)
		{
			currentNode = currentNode.next;
		}
		return currentNode.data;
		
	}
	/*
	 * returns a node at a specific index
	 */
	public ListNode getNode(int index)
	{
		ListNode currentNode = headNode;
		for(int i =0; i < index; i++)
		{
			currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	/*this method sets the node value at a given index
	 * @param value: the new value for the node
	 * @param index: the specific node index to manipulate
	 */
	public void set(String value, int index)
	{
		ListNode currentNode = headNode;
		for(int i =0; i < index; i++)
		{
			currentNode = currentNode.next;
		}
		currentNode.data = value;
		
	}
	
	/*
	 * this method adds a node at a specific index with a specific value
	 * @param value: the new nodes value
	 * @param index: the index to insert the node
	 */
	public void add(String value, int index)
	{
		if(index < 0)
		{
			throw new NullPointerException("thats negative yo");
		}
		ListNode newNode = new ListNode(value);
		ListNode currentNode = headNode;
		if(numInList != 0)
		{
			if(index == 0)
			{
				newNode.next = currentNode;
				headNode = newNode;
			}
			else
			{
				for(int i =0; i < index -1; i++)
				{
					currentNode = currentNode.next;
				}
				newNode.next = currentNode.next;
				currentNode.next = newNode;
			}
		}
		else
		{
			headNode = newNode;
		}
		numInList++;
	}
	
	/*
	 * this method removes a specific link from the list
	 * @param the indexed link you want to remove in storage
	 * returns the removed links data
	 */
	public String remove(int index)
	{
		if(index > size())
		{
			throw new NullPointerException("out of range");
		}
		ListNode currentNode = headNode;
		if(!headNode.equals(null))
		{
			if(index == 0)
			{
				ListNode newHeadNode = currentNode.next;
				String toReturn = currentNode.data;
				currentNode = null;
				headNode = newHeadNode;
				numInList--;
				return toReturn;
			}
			else
			{
				for(int i =0; i < index -1; i++)
				{
					currentNode = currentNode.next;
				}
				currentNode.next = (currentNode.next).next;
				ListNode toRemove = currentNode.next;
				String toReturn = toRemove.data;
				toRemove = null;
				numInList--;
				return toReturn;
			}
			
		}
		return null;
	}
	
	/*
	 * returns a string representation of the nodes
	 * 
	 */
	public String toString()
	{
		String LinkListString = "{";
		for(int i = 0; i < numInList; i++)
		{
			if(i != numInList -1)
			{
				LinkListString = LinkListString.concat(get(i) + ", ");
			}
			else
			{
				LinkListString = LinkListString.concat(get(i) + "}" + " (capacity = " + numInList + ")");
			}
		}
		return LinkListString;
	}
}