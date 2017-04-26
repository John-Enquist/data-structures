/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */

/*
 * a node for the Binary Search tree
 */
public class BSTNode<T extends Comparable<T>> {
	
	public T value;
	public BSTNode<T> llink;
	public BSTNode<T> rlink;


	/*
	 * creates a new BSTNode
	 * @parameter newValue: the value to be given
	 * to the new BSTNode
	 */
	public BSTNode(T newValue)
    {
        value = newValue;
        llink = null;
        rlink = null;
    } 
	
	/*
	 * returns a string representation of the node.
	 */
	public String toString()
    {
        return value.toString();
    }
	
	/*
	 * determines whether this is a leaf or node.
	 * @return true iff the node is a leaf, else false
	 */
	public boolean isLeaf()
    {
		if(this.rlink == null && this.llink == null){
			return true;
		}
		return false;

    }

}
