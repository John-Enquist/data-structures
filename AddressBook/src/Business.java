import java.util.Scanner;


public class Business implements Contact{

	public String businessName;
	public String businessAddress;
	public String emailAddress;
	public String phoneNumber;
	public String businessHours;
	
	// gets the businesses name
	public String getName(){
		return businessName;
	}
	
	// gets the businesses address
	public String getAddress(){
		return businessAddress;
	}
	
	// gets the businesses email
	public String getEmail(){
		return emailAddress;
	}
	// gets the businesses phone number
	public String getPhone(){
		return phoneNumber;
	}
	
	// gets the businesses hours
	public String getBusinessHours(){
		return businessHours;
	}
	
	//sets the businesses name
	//@parameter name: the name of the business
	public void setBusinessName(String name){
		this.businessName = name;
	}
	
	// sets the businesses name using scanner
	public void setBusinessName(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Business Name");
		String name = scan.next();
		businessName = name;	
	}
	
	// sets the businesses address
	public void setBusinessAddress(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Business Address");
		String address = scan.nextLine();
		businessAddress = address;	
	}
	
	// sets the businesses email
	public void setEmail(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Email");
		String theEmail = scan.nextLine();
		emailAddress = theEmail;	
	}
	
	// sets the businesses phone number
	public void setPhoneNumber(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Phone #");
		String theNumber = scan.nextLine();
		phoneNumber = theNumber;
	}
	
	//sets the business hours
	public void setBusinessHours(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Business Hours");
		String hours = scan.nextLine();
		businessHours = hours;
	}
	
	// returns a string representation of the business information
	public String toString(){
		String concat = "";
		concat = concat.concat(getName() + "\n");
		concat = concat.concat("__email__" + "\n");
		concat = concat.concat(getEmail() + "\n");
		concat = concat.concat("__phone#__" + "\n");
		concat = concat.concat(getPhone() + "\n");
		concat = concat.concat("__businessHours__" + "\n");
		concat = concat.concat(getBusinessHours() + "\n");
		concat = concat.concat("__address__" + "\n");
		concat = concat.concat(getAddress() + "\n");
		concat = concat.concat("________" + "\n");
		return concat;
	}

	// compares this contact to another contact
	//@parameter other: the other contact to compare to
	public int compareTo(Contact other) {
		return this.getName().compareToIgnoreCase((other.getName()));
	}
}
