
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */

public class BinarySearchTreeTest {

	private BinarySearchTree<String> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<String> ();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}


	@Test
	public void testConstructor () {
		assertEquals ("A new tree should be empty", "", tree.toString());
	}
	
	@Test
	public void testAdd_toEmptyTree () {
		tree.add("K");
		assertEquals ("empty tree + K", "K", tree.toString());
	}
	
	@Test
	public void testAdd_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "D\nK", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "K\n D", tree.showTree());
	}

	
	@Test
	public void testFindFirstInTree() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		assertEquals ("finding K", "K", tree.find("K"));
	}
	
	@Test
	public void testFindMiddleInTree() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		assertEquals ("finding D", "D", tree.find("D"));
	}
	
	@Test
	public void testFindLastInTree() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		assertEquals ("finding B", "B", tree.find("B"));
	}
	
//	@Test
//	public void testFindNotInTree() {
//		tree.add("K");
//		tree.add("D");
//		tree.add("B");
//		assertEquals ("not in tree", null, tree.find("S"));
//	}
	
	
	@Test
	public void testRemoveNodeAtBeginning() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		tree.add("C");
		tree.add("F");
		tree.add("M");
		assertEquals ("should remove node K", "K", tree.remove("K"));
	}
	
	@Test
	public void testRemoveNodeAtEnd() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		tree.add("C");
		tree.add("F");
		tree.add("M");
		assertEquals ("should remove node M", "M", tree.remove("M"));
	}
	
	@Test
	public void testRemoveNodeInMiddle() {
		tree.add("K");
		tree.add("D");
		tree.add("B");
		tree.add("C");
		tree.add("F");
		tree.add("M");
		assertEquals ("should remove node B", "B", tree.remove("B"));
	}
//	@Test
//	public void testRemoveNothing() {
//		tree.add("K");
//		tree.add("D");
//		tree.add("B");
//		tree.add("C");
//		tree.add("F");
//		tree.add("M");
//		assertEquals ("should remove node Z", null, tree.remove("Z"));
//	}
	
	@Test
	public void testToString() {
		tree.add("A");
		tree.add("D");
		tree.add("B");
		tree.add("C");
		tree.add("F");
		tree.add("E");
		assertEquals ("should show in order", "A\nB\nC\nD\nE\nF", tree.toString());
	}
	
	
//	@Test
//	public void testShowTree() {
//		tree.add("A");
//		tree.add("D");
//		tree.add("B");
//		tree.add("C");
//		tree.add("F");
//		tree.add("E");
//		assertEquals ("should show in order", "A\nB\nC\nD\nE\nF", tree.showTree());
//	}
	
	
	

	// Add more tests.     
	
}
