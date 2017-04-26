
public class GenericLinkedListTests {

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
		GenericLinkedList<String> linkedList = new GenericLinkedList<String>();
		linkedList.add(0,"a");
		linkedList.add(1, "b");
		linkedList.add(2, "c");
		linkedList.add(3, "d");		
		System.out.println("_____________________________");
		Testing.assertEquals("adding/showing links", "\na\nb\nc\nd", linkedList.toString());
		
		System.out.println("_____________________________");
		System.out.println("adding in a taken location");
		linkedList.add(2, "e");
		Testing.assertEquals("Default constructor, initial size", "\na\nb\ne\nc\nd", linkedList.toString());
		
		System.out.println("_____________________________");
		linkedList.add(0, "first");
		Testing.assertEquals("Default constructor, initial size", "first, a, b, e, c, d", linkedList.toString());
		
		System.out.println("_____________________________");
		System.out.println("removing links");
		linkedList.remove("d");
		Testing.assertEquals("Default constructor, initial size", "{first, a, b, c, d} (capacity = 5)", linkedList.toString());
		System.out.println("____________");
		linkedList.insertSorted("b");
		System.out.println("____________");
		Testing.assertEquals("Default constructor, initial size", "{first, a, b, c, d} (capacity = 5)", linkedList.toString());
		Testing.assertEquals("finding data", "b", linkedList.find("b"));
	}


}
