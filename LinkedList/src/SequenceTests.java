public class SequenceTests {

	public static void main(String[] args) {
		
		Testing.setVerbose(true);
		System.out.println("Starting Tests");

		testCreate();
		johnsAddingTests();
		johnsAdvancingTests();
		johnsAddAllTests();
		johnsCloneTests();
		johnsMiscellaneousTests();

		// add calls to more test methods here.
		// each of the test methods should be
		// a static method.

		System.out.println("Tests Complete");
	}

	private static void testCreate() {
		Testing.testSection("Creation tests");

		Sequence s1 = new Sequence();
		Testing.assertEquals("Default constructor", "{} (capacity = 10)", s1.toString());
		Testing.assertEquals("Default constructor, initial size", 0, s1.size());

		Sequence s2 = new Sequence(20);
		Testing.assertEquals("Non-default constructor", "{} (capacity = 20)",
				s2.toString());
		Testing.assertEquals("Non-default constructor, initial size", 0, s2.size());
	}
	private static void johnsAddingTests() {
		Sequence s1 = new Sequence();
		s1.addBefore("meh");
		s1.addBefore("bleh");
		s1.addBefore("geh");
		Testing.assertEquals("adding elements", "{>geh, bleh, meh} (capacity = 10)", s1.toString());
		s1.addAfter("lol");
		Testing.assertEquals("adding after element 1", "{geh, >lol, bleh, meh} (capacity = 10)", s1.toString());
		s1.advance();
		s1.advance();
		s1.advance();
		s1.addAfter("work?");
		Testing.assertEquals("adding outside range", "{geh, lol, bleh, meh, >work?} (capacity = 10)", s1.toString());
		
		}
		
	private static void johnsAdvancingTests(){
		Sequence s1 = new Sequence();
		s1.addBefore("meh");
		s1.addBefore("bleh");
		s1.addBefore("geh");
		Testing.assertEquals("no advance yet", "{>geh, bleh, meh} (capacity = 10)", s1.toString());
		s1.advance();
		Testing.assertEquals("advancing once", "{geh, >bleh, meh} (capacity = 10)", s1.toString());
		s1.advance();
		Testing.assertEquals("advancing twice", "{geh, bleh, >meh} (capacity = 10)", s1.toString());
		s1.advance();
		Testing.assertEquals("advancing past capacity", "{geh, bleh, meh} (capacity = 10)", s1.toString());
		
	}
	
	private static void johnsAddAllTests(){
		Sequence s1 = new Sequence();
		s1.addBefore("meh");
		s1.addBefore("bleh");
		s1.addBefore("geh");
		Sequence s2 = new Sequence();
		s2.addBefore("meh");
		s2.addBefore("bleh");
		s2.addBefore("geh");
		s2.toString();
		s1.addAll(s2);
		Testing.assertEquals("addall method", "{geh, bleh, meh, geh, bleh, >meh} (capacity = 10)", s1.toString());
	}
	
	private static void johnsCloneTests(){
		Sequence s1 = new Sequence();
		s1.addBefore("meh");
		s1.addBefore("bleh");
		s1.addBefore("geh");
		Sequence theClone = s1.clone();
		Testing.assertEquals("testing cloning method", "{>geh, bleh, meh} (capacity = 10)", theClone.toString());
	}
	
//	private static void johnsConcatenationTests(){
//		Sequence s1 = new Sequence();
//		s1.addBefore("meh");
//		s1.addBefore("bleh");
//		s1.addBefore("geh");
//		Sequence s2 = new Sequence();
//		s2.addBefore("meh");
//		s2.addBefore("bleh");
//		s2.addBefore("geh");
//		Testing.assertEquals("testing concat method", "{>geh, bleh, meh} (capacity = 10)", concatenation(s1,s2).toString());
//	}
	private static void johnsMiscellaneousTests(){
		Sequence s1 = new Sequence(3);
		s1.addBefore("meh");
		s1.addBefore("bleh");
		s1.addBefore("geh");
		s1.addBefore("yo");
		Testing.assertEquals("testing capacity", "{>yo, geh, bleh, meh} (capacity = 7)", s1.toString());
		Testing.assertEquals("getting current element", "yo", s1.getCurrent().toString());
		s1.removeCurrent();
		Testing.assertEquals("removing the current element", "{>geh, bleh, meh} (capacity = 7)", s1.toString());
		Sequence s2 = s1.clone();
		System.out.println(s1.equals(s2));
		
		
		
		
	}

}
