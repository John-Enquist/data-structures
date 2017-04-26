
public class AddressBookTester {

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
		AddressBook contacts = new AddressBook();
		contacts.add();
		contacts.add();
		contacts.add();
		System.out.println(contacts.book.toString());
		System.out.println("_______finding now_____");
		contacts.find("dog");
		contacts.find("fatstore");
		contacts.remove("dog");
		contacts.find("dog");
		contacts.remove("fatstore");
		contacts.remove("dumbo");
		System.out.println(contacts.book.toString());
		
	}


}

