import java.util.Scanner;

public class AddressBook {

	GenericLinkedList<Contact> book;
	
	public AddressBook() {
		book = new GenericLinkedList<Contact>();
	}
	
	// adds a new contact to the addressbook
	public void add(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Type (p) for person, (b) for business (without brackets) ");
		String input = scan.next();
		if(input.equals("p"))
		{
			Person newPerson = new Person();
			newPerson.setFirstName();
			newPerson.setLastName();
			newPerson.setEmail();
			newPerson.setPhoneNumber();
			newPerson.setBirthday();
			book.insertSorted(newPerson);	
		}
		if(input.equals("b"))
		{
			Business newBusiness = new Business();
			newBusiness.setBusinessName();
			newBusiness.setEmail();
			newBusiness.setPhoneNumber();
			newBusiness.setBusinessHours();
			newBusiness.setBusinessAddress();
			book.insertSorted(newBusiness);
		}
		
	}
	/*
	 * finds a given contact given a string name
	 * @parameter name: the contact to be found in the addressbook
	 */
	public void find(String name){
		Business findingContact = new Business();
		findingContact.setBusinessName(name);
		Contact theContact = book.find(findingContact);
		if(theContact == null)
		{
			System.out.println("this contact is not in the addressbook");
		}
		else
		{
			System.out.println(theContact);
		}
		
	}
	/*
	 * finds and removes a given contact given the contacts name
	 * @parameter name: the name of the contact to be removed
	 */
	public void remove(String name){
		Business findingContact = new Business();
		findingContact.setBusinessName(name);
		Contact theContact = book.find(findingContact);
		System.out.println("this contact was removed from the addressbook");
		System.out.println(book.remove(theContact));
	}
	

}
