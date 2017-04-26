public class Sequence {
	/**
	 * Creates a new sequence with initial capacity 10.
	 */
	int theCurrentElement;
	int theCurrentCapacity;
	int numOfelements;
	LinkedList storage;
	boolean hasCurrent = false;
	int defaultCapacity;
	
	
	
	public Sequence() {

		this.storage = new LinkedList();
		this.numOfelements = storage.size();
		this.theCurrentElement = 0;
		defaultCapacity = 10;
		theCurrentCapacity = 10;
	}

	/**
	 * Creates a new sequence.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the bag.
	 */
	public Sequence(int initialCapacity) {
		theCurrentCapacity = initialCapacity;
		this.storage = new LinkedList();
		this.numOfelements = 0;
		this.theCurrentElement = 0;
		
	}

	/**
	 * Adds a string to the sequence in the location before the current element.
	 * If the sequence has no current element, the string is added to the
	 * beginning of the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addBefore(String value) {
		if(storage.size() == theCurrentCapacity)
		{
			ensureCapacity(2*theCurrentCapacity + 1);
		}
		if(theCurrentElement == 0)
		{
			storage.add(value, 0);
			hasCurrent = true;
		}
		else
		{
			storage.add(value, theCurrentElement);
		}
		
		
	}
	
	/**
	 * Adds a string to the sequence in the location after the current element.
	 * If the sequence has no current element, the string is added to the end of
	 * the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addAfter(String value) {
		if(theCurrentElement == 0)
		{
			storage.add(value, 1);
			theCurrentElement = theCurrentElement +1;
		}
		else if(theCurrentElement == theCurrentCapacity -1)
		{
			ensureCapacity(2*theCurrentCapacity + 1);
			storage.add(value, theCurrentElement +1);
			theCurrentElement = theCurrentElement +1;
		}
		else if(hasCurrent == false)
		{
			theCurrentElement = storage.size();
			storage.add(value, theCurrentElement);
		}
		else
		{
			storage.add(value, theCurrentElement +1 );
			theCurrentElement = theCurrentElement +1;
		}
	}

	/**
	 * Places the contents of another sequence at the end of this sequence.
	 * 
	 * If adding all elements of the other sequence would exceed the capacity of
	 * this sequence, the capacity is changed to make room for all of the
	 * elements to be added.
	 * 
	 * @param addend
	 *            the sequence whose contents should be added.
	 */
	public void addAll(Sequence addend) {
		if(storage.size() + addend.size() > theCurrentCapacity)
		{
			ensureCapacity(storage.size()+ addend.size());
		}
		theCurrentElement = storage.size();
		for(int i = 0; i < addend.storage.size(); i++)
		{
			storage.add(addend.storage.get(i), theCurrentElement);
			theCurrentElement = theCurrentElement +1;
		}
		theCurrentElement = storage.size() -1;
	}
	

	/**
	 * Move forward in the sequence so that the current element is now the next
	 * element in the sequence.
	 * 
	 * If the current element was already the end of the sequence, then
	 * advancing causes there to be no current element.
	 * 
	 * Precondition: should only be called when there is a current element.
	 */
	public void advance() {
		if(this.hasCurrent)
		{
			if(theCurrentElement == (storage.size() -1))
			{
				this.hasCurrent = false;
				theCurrentElement = -1;
			}
			else
			{
				this.theCurrentElement += 1;
			}	
		}
	}

	/**
	 * Make a copy of this sequence. Subsequence changes to the copy do not
	 * affect the current sequence, and vice versa.
	 * 
	 * @return the copy of this sequence.
	 */
	public Sequence clone() {
		Sequence newSequence = new Sequence(theCurrentCapacity);
		for(int i = 0; i < storage.size(); i++)
		{
			newSequence.addAfter(storage.get(i));
		}
		newSequence.theCurrentElement = theCurrentElement;
		return newSequence;
	}

	/**
	 * Create a new sequence that contains all of the elements of one sequence
	 * followed by all of the elements of another sequence.
	 * 
	 * The new sequence does not have a current element. The new sequence has
	 * capacity equal to the sum of the capacities of the sequences being
	 * concatenated.
	 * 
	 * @param s1
	 *            the sequence whose elements should come first in the
	 *            concatenation
	 * @param s2
	 *            the sequence whose elements should come second
	 */
	public static Sequence concatenation(Sequence s1, Sequence s2) {
		
		Sequence bigSequence = new Sequence();
		bigSequence.addAll(s1);
		bigSequence.addAll(s2);
		bigSequence.hasCurrent = false;
		return bigSequence;
	}

	/**
	 * Change the current capacity of this sequence. The sequence's capacity
	 * will be changed to be at least a minimum capacity.
	 * 
	 * @param minCapacity
	 *            the minimum capacity that the sequence should now have.
	 */
	public void ensureCapacity(int minCapacity) {
		if(minCapacity >= theCurrentCapacity)
		{
			theCurrentCapacity = minCapacity;
		}
	}

	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() {
		return theCurrentCapacity;
	}

	/**
	 * @return the element at the current location in the sequence, or null if
	 *         there is no current element.
	 */
	public String getCurrent() {
		if(this.hasCurrent)
		{
			return this.storage.get(theCurrentElement);
		}
		return null;
	}

	/**
	 * @return true if and only if the sequence has a current element.
	 */
	public boolean isCurrent() {
		return this.hasCurrent;
	}

	/**
	 * Remove the current element from this sequence. The following element, if
	 * there was one, becomes the current element. If there was no following
	 * element (current was at the end of the sequence), the sequence now has no
	 * current element.
	 * 
	 * If there is no current element, does nothing.
	 */
	public void removeCurrent() {
		if(isCurrent())
		{
			storage.remove(theCurrentElement);
			//should automatically fix by sliding down links, but should test
		}
	
	}

	/**
	 * @return the number of elements stored in the sequence.
	 */
	
	public int size() {
		return this.numOfelements;
	}

	/**
	 * Sets the current element to the start of the sequence. If the sequence is
	 * empty, the sequence has no current element.
	 */
	public void start() {
		this.hasCurrent = true;
		this.theCurrentElement = 0;
	}

	/**
	 * Reduce the current capacity to its actual size, so that it has capacity
	 * to store only the elements currently stored.
	 */
	public void trimToSize() {
		theCurrentCapacity = storage.size();
	}

	/**
	 * Produce a string representation of this sequence. The current location is
	 * indicated by a >. For example, a sequence with "A" followed by "B", where
	 * "B" is the current element, and the capacity is 5, would print as:
	 * 
	 * {A, >B} (capacity = 5)
	 * 
	 * An empty sequence with a capacity of 10 would print as:
	 * 
	 * {} (capacity = 10)
	 * 
	 * @return a string representation of this sequence.
	 */
	public String toString() {
		String sequenceString = "{";
		for(int i = 0; i< storage.size(); i++)
		{
			String theData = storage.get(i);
			if(i != storage.size() -1 )
			{
				if(i == theCurrentElement)
				{
					sequenceString = sequenceString.concat(">" + theData + ", ");
				}
				else
				{
					sequenceString = sequenceString.concat(theData + ", ");
				}
			}
			else
			{
				if(i == theCurrentElement)
				{
					sequenceString = sequenceString.concat(">" + theData);
				}
				else
				{
					sequenceString = sequenceString.concat(theData);
				}
			}
		}
		sequenceString = sequenceString.concat("} (capacity = " + getCapacity() + ")");
		return sequenceString;

	}

	/**
	 * Checks whether another sequence is equal to this one. To be considered
	 * equal, the other sequence must have the same elements, in the same order,
	 * and with the same element marked current. The capacity can differ.
	 * 
	 * @param other
	 *            the other Sequence with which to compare
	 * @return true iff the other sequence is equal to this one.
	 */
	public boolean equals(Sequence other) {
		
		for(int i = 0; i < storage.size(); i++)
		{
			if(!storage.get(i).equals(other.storage.get(i)))
			{
				return false;
			}
		}
		return true;

	}
}