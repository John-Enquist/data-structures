/*
 * Final project John Enquist
 * Project 8: We The People
 * I hereby affirm that i carried out my academic endeavors with full academic
 * honesty.
 * last edited (3/9/2015)
 * with help from Kristina Striegnitz, Aaron Cass, Nick Webb
 */

public class Client {

	public static void main(String[] args)
	{
		Index theIndex = new Index();
		theIndex.createIndex("usconst.txt");
		System.out.println(theIndex.index.showTree());
		System.out.println("________");

	}
}