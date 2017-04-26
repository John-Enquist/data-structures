/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */


public class BinarySearchTree<T extends Comparable<T>> {

	BSTNode<T> root; 
	int numInList;

	public BinarySearchTree() {
		root = null;
		numInList = 0;
	}

	/*
	 * finds the node in the tree that stores toFind
	 * using the compareTo method. if no nodes match
	 * toFind then this method returns null
	 * @parameter toFind: the node to find
	 */
	public T find(T toFind){
		if(root != null){
			BSTNode<T> found = search(root, toFind);
			if(found != null){
				return found.value;
			}
		}
		return null;
	}

	/*
	 * adds a new node with the value toAdd to the tree
	 * @parameter toAdd: the value to store in a new node 
	 * and add to the tree
	 */
	public void add(T toAdd){
		if (root == null){
			root = new BSTNode<T>(toAdd);
			numInList++;
			return;
		}   
		else{
			BSTNode<T> parentNode = null;
			BSTNode<T> currentNode = root;
			while(currentNode != null){
				if( toAdd.compareTo(currentNode.value) <= 0){
					parentNode = currentNode;
					currentNode = currentNode.llink;			
				}
				else if(toAdd.compareTo(currentNode.value) > 0){
					parentNode = currentNode;
					currentNode = currentNode.rlink;
				}
			}
			if(toAdd.compareTo(parentNode.value) <= 0 ){
				parentNode.llink = new BSTNode<T>(toAdd);
			}
			else{
				parentNode.rlink = new BSTNode<T>(toAdd);
			}
		}
		numInList++;
		return;
	}

	/*
	 * finds a node in the tree that matches the value
	 * of toRemove, and removes the node from the tree,
	 * then returns that nodes value. If no node matches
	 * toRemove, this method returns null
	 * @parameter toRemove: the value of the node to remove
	 * @return the value of the removed element iff the element was in
	 * the tree, else returns null.
	 */
	public T remove(T toRemove)
	
	{
		if(find(toRemove) != null) {
			root = removeFromSubtree(root, toRemove);
			numInList --;
			return toRemove;
		}
		return null;
	}
	
	/**
	 * Finds the TreeNode to remove, then removes it based on how many children it has.
	 * 
	 * @parameter root TreeNode of the Subtree, Element toRemove
	 * @return root of the subtree without the inputed TreeNode
	 */
	private BSTNode<T> removeFromSubtree(BSTNode<T> current, T toRemove)
	{
		if(current != null) 
		{
			if(current.value.compareTo(toRemove) > 0) 
			{
				current.llink = removeFromSubtree(current.llink, toRemove);
			} 
			else if (current.value.compareTo(toRemove) < 0) 
			{
				current.rlink = removeFromSubtree(current.rlink, toRemove);
			} 
			else 
			{
				current = removeHelper(current, toRemove);
			}
		}
		return current;
	}
	
	/**
	 * Removes the TreeNode from the BST, calling removeFromSubtree based on how many children the TreeNode has.
	 * 
	 * @param toRemove
	 * @return value of new TreeNode
	 */
	private BSTNode<T> removeHelper(BSTNode<T> toRemove, T element) 
	{
		if(toRemove.isLeaf()) {
			return null;
		} else if(toRemove.llink != null) {
			toRemove = removeFromSubtree(toRemove.llink, element);
		} else if(toRemove.rlink != null) {
			toRemove = removeFromSubtree(toRemove.rlink, element);
		} else {
			BSTNode<T> minData = getMin(toRemove.rlink);
			toRemove.value = minData.value;
			toRemove.rlink = removeFromSubtree(toRemove.rlink, minData.value);
		}
		return toRemove;
	}
	
	/**
	 * @param theRoot of a subtree
	 * @return minimum element in the subtree
	 */
	private BSTNode<T> getMin(BSTNode<T> theRoot)
	{
		if(theRoot.llink == null) {
			return theRoot;
		} else {
			return getMin(theRoot.llink);
		}
	}

	/*
	 * returns a string representation of the elements in the
	 * tree based on the order determined by compareTo
	 *
	 */
	public String toString(){
		return preOrderToString(root).substring(0,preOrderToString(root).length()-1);
//		return preOrderToString(root);

	}
	/**
	 * Finds and returns the TreeNode in the BST .
	 * 
	 * @param element input
	 * @return TreeNode in the BST, or null if the BST does not contain it.
	 */
	private BSTNode<T> search(BSTNode<T> currentNode, T element)
	{
		if(currentNode != null) {
			if(element.compareTo(currentNode.value) > 0) 
			{
				return search(currentNode.rlink, element);
			} 
			else if(element.compareTo(currentNode.value) < 0) 
			{
				return search(currentNode.llink, element);
			}
			else if(currentNode.value.compareTo(element) == 0){
				return currentNode;	
			}
		}
		return null;
	}


	private String preOrderToString(BSTNode<T> theRoot) {
		String resultString = "";
		if(theRoot != null) {
			if(theRoot.llink != null) {
				resultString += preOrderToString(theRoot.llink);
			}
			
			resultString += theRoot.toString() + "\n";
			if(theRoot.rlink != null) {
				resultString += preOrderToString(theRoot.rlink);
			}
		}
		return  resultString ;
	}
	


	/*
	 * returns a string representation of the tree in preorder
	 * order, with proper line breaks and indentation
	 */
	public String showTree(){
		return preOrder(root, 0, 0).substring(0,preOrder(root, 0, 0).length()-1);
	}

	/*
	 * returns a string representation of the tree in preOrder traversal
	 * @param theRoot, the root to begin at
	 * @param treeLevel: the number of spaces to add before the value to show
	 * the level
	 * @param aCounter: used to know when preorder is doing its last node
	 * in order to not use \n
	 */
	private String preOrder(BSTNode<T> theRoot, int treeLevel, int aCounter) {
		String preOrderTree = "";
		int counter = aCounter;
		if(theRoot != null){
			preOrderTree += printSpaces(treeLevel);
			if(counter == numInList -1){
				preOrderTree += theRoot.toString();
			}
			else{
				preOrderTree += theRoot.toString() +"\n";
			}
			counter++;
			preOrderTree += preOrder(theRoot.llink, treeLevel +1, counter);
			preOrderTree += preOrder(theRoot.rlink, treeLevel +1, counter);	
		}
		return preOrderTree;
  
	}
	/*
	 * returns a string of spaces 
	 * @param numOfSpaces: the number of spaces to return
	 */
	private String printSpaces(int numOfSpaces){
		String spaces = "";
		for(int i = 0; i < numOfSpaces; i++){
			spaces += " ";
		}
		return spaces;
	}
}
