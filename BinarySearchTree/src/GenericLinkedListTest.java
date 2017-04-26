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

public class GenericLinkedListTest {

	private GenericLinkedList<String> ll;
	
	@Before
	public void setUp() throws Exception {
		ll = new GenericLinkedList<String> ();
	}

	@After
	public void tearDown() throws Exception {
		ll = null;
	}

	// There should be at most one assert statement per testing method.
	@Test
	public void testConstructor () {
		assertEquals ("New list is empty", "{}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_toEmptyList () {
		ll.addAtTail("A");
		assertEquals ("{} + A", "{A}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_nonEmptyList () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("{A} + B", "{A, B}", ll.toString());
	}
	
	@Test
	public void testToRemove_nonEmptyListEnd(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		ll.remove("C");
		assertEquals("removing c", "{A, B}", ll.toString());
	}
	
	@Test
	public void testToRemove_nonEmptyListMiddle(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		ll.remove("B");
		assertEquals("removing b", "{A, C}", ll.toString());
	}
	
	@Test
	public void testToRemove_nonEmptyListBeginning(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		ll.remove("A");
		assertEquals("removing a", "{B, C}", ll.toString());
	}

	@Test
	public void testFindAtEnd(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals("finding C", "C", ll.find("C"));
	}
	// Add more tests.   
	@Test
	public void testFindAtBeginning(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals("finding A", "A", ll.find("A"));
	}
	@Test
	public void testFindAtMiddle(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals("finding B", "B", ll.find("B"));
	}
	@Test
	public void testFindNoting(){
		ll.addAtTail("A");
		ll.addAtTail("B");
		ll.addAtTail("C");
		assertEquals("finding element not in list", null, ll.find("D"));
	}
}
