
public class GenericListNode<T extends Comparable<T>> {
	
	public T data;
	public GenericListNode<T> next;

	//default constructor
	public GenericListNode()
	{
		data = null;
		next = null;
	}
	
	// constructor for listNode
	//@parameter value: the t value for the nodes data
	public GenericListNode(T value) 
	{
		data = value;
		next = null;
	}
	
	// constructor for listnode
	//@parameter value: the t value for the nodes data
	//@parameter: next: the next node in the linked list
	public GenericListNode(T value, GenericListNode<T> next)
	{
		data = value;
		this.next = next;
	}
	
	// returns the nodes data (unused currently)
	public T toReturn()
	{
		return data;
	}

}
