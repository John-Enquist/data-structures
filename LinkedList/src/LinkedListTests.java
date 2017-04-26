
public class LinkedListTests {

public static void main(String[] args) {
		
		Testing.setVerbose(true);
		System.out.println("Starting Tests");
		johnsTests();
		
		
		// add calls to more test methods here.
		// each of the test methods should be
		// a static method.

		System.out.println("Tests Complete");
	}
	public static void johnsTests()
	{
		LinkedList linkedList = new LinkedList();
		linkedList.add("a", 0);
		linkedList.add("b", 1);
		linkedList.add("c", 2);
		linkedList.add("d", 3);		
		System.out.println("_____________________________");
		Testing.assertEquals("adding/showing links", "{a, b, c, d} (capacity = 4)", linkedList.toString());
		
		System.out.println("_____________________________");
		System.out.println("adding in a taken location");
		linkedList.add("e", 2);
		Testing.assertEquals("Default constructor, initial size", "{a, b, e, c, d} (capacity = 5)", linkedList.toString());
		
		System.out.println("_____________________________");
		linkedList.add("first", 0);
		Testing.assertEquals("Default constructor, initial size", "{first, a, b, e, c, d} (capacity = 6)", linkedList.toString());
		
		System.out.println("_____________________________");
		System.out.println("removing links");
		linkedList.remove(3);
		Testing.assertEquals("Default constructor, initial size", "{first, a, b, c, d} (capacity = 5)", linkedList.toString());
		
		System.out.println("_____________________________");
		System.out.println("setting a links data");
		linkedList.set("fixed", 2);
		Testing.assertEquals("Default constructor, initial size", "{first, a, fixed, c, d} (capacity = 5)", linkedList.toString());
		
		
	}


}
