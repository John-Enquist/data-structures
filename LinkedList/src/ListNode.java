
public class ListNode {

	
	public String data;
	public ListNode next;
	
	public ListNode(String value) 
	{
		data = value;
		next = null;
	}
	
	public ListNode(String value, ListNode next)
	{
		data = value;
		this.next = next;
	}
	public String toString()
	{
		return data;
	}
	


}
