import java.util.Scanner;

/*
 * this class represents a persons contact information that one would put in an addressbook
 */
public class Person implements Contact{

	public String lastName;
	public String firstName;
	public String emailAddress;
	public String phoneNumber;
	public String birthday;
	

	// gets the persons full name
	public String getFullName(){
		return lastName + ", " + firstName;
	}
	
	// gets only the last name
	public String getName(){
		return lastName;
	}
	
	// gets the persons email
	public String getEmail(){
		return emailAddress;
	}
	
	// gets the persons phone number
	public String getPhone(){
		return phoneNumber;
	}
	
	// gets the persons birthday
	public String getBirthday(){
		return birthday;
	}
	
	// sets the persons first name
	public void setFirstName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter First Name");
		String theFirstName = scan.nextLine();
		firstName = theFirstName;	
	}
	
	// sets the persons last name
	public void setLastName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Last Name");
		String theLastName = scan.next();
		if(theLastName == ""){
			System.out.println("Enter Last Name Please");
			theLastName = scan.next();
		}
		lastName = theLastName;	
	}
	
	// sets the persons email address
	public void setEmail(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Email");
		String theEmail = scan.nextLine();
		emailAddress = theEmail;	
	}
	
	// sets the persons phone number
	public void setPhoneNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Phone #");
		String theNumber = scan.nextLine();
		phoneNumber = theNumber;
	}
	
	// sets the persons birthday
	public void setBirthday(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Birthday");
		String theBirthday = scan.nextLine();
		birthday = theBirthday;
	}
	
	// returns a string representation of the persons contact
	public String toString(){
		String concat = "";
		concat = concat.concat(getFullName() + "\n");
		concat = concat.concat("__email__" + "\n");
		concat = concat.concat(getEmail() + "\n");
		concat = concat.concat("__phone#__" + "\n");
		concat = concat.concat(getPhone() + "\n");
		concat = concat.concat("__birthday__" + "\n");
		concat = concat.concat(getBirthday() + "\n");
		concat = concat.concat("________" + "\n");
		return concat;
		
	}
	
	// compares this contact to another 
	//@ parameter the other contact
	public int compareTo(Contact other) {
		return this.getName().compareToIgnoreCase((other.getName()));
	}
	
	// used to fulfill the contact requirments
	public String getAddress() {
		return null;
	}
}
