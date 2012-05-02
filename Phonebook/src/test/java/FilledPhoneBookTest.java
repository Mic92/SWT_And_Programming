import junit.framework.TestCase;


public class FilledPhoneBookTest extends TestCase {
	private Person p1,p2,p3,p4,p5;
	private TelephoneNumber tn1,tn2,tn3,tn4,tn5;
	private Address a1,a2,a3,a4,a5;
	protected PhoneBook pb;
	protected int maxEntries = 15;

	public void setUp() throws Exception {
//		 Erzeugung mehrerer Personen:
		p1 = new Person("1","1","1");
		p2 = new Person("2","2","2");
		p3 = new Person("3","3","3");
		p4 = new Person("4","4", "4");
		p5 = new Person("5","5","5");
		
		//Erzeugung mehrerer Telefonnummern:
		tn1 = new TelephoneNumber("1","1");
		tn2 = new TelephoneNumber("2","2");
		tn3 = new TelephoneNumber("3","3");
		tn4 = new TelephoneNumber("4","4");
		tn5 = new TelephoneNumber("5","5");
		
		//Erzeugen mehrerer Anschriften:
		a1 = new Address("1","1","1","1","1");
		a2 = new Address("2","2","2","2","2");
		a3 = new Address("3","3","3","3","3");
		a4 = new Address("4","4","4","4","4");
		a5 = new Address("5","5","5","5","5");
		
		pb = new PhoneBook(maxEntries);
		pb.addNewEntry(tn1, p1, a1);
		pb.addNewEntry(tn2, p2, a2);
		pb.addNewEntry(tn3, p3, a3);
		pb.addNewEntry(tn4, p4, a4);
		pb.addNewEntry(tn5, p5, a5);
	}

	public void testAddNewEntry() {
		int i = pb.countEntries();
		boolean actualValue = pb.addNewEntry(new TelephoneNumber("6","6"), new Person("6","6","6"), new Address("6","6","6","6","6"));
		assertTrue("It seems that it was not possible to add a new entry to a phone book which was not yet full! The method addNewEntry should return true when a new entry was added!",actualValue);
		assertEquals("The newly added entry was not correct! Either you did not set the mark correctly or the adding of the entry went wrong!","6",pb.getMarkedEntry().getPerson().getName());
		assertTrue("The number of counted entries was not correct after adding one entry!",i!=pb.countEntries());
	}

	public void testRemoveMarkedEntry() {
		int i = pb.countEntries();
		pb.markPreviousEntry();
		boolean actualValue = pb.removeMarkedEntry();
		assertTrue("It was not possible to remove an entry from a non empty phone book!",actualValue);
		assertEquals("After removing an entry the marked entry was not correct! Set the new entry to the entry following the removed one!","5",pb.getMarkedEntry().getPerson().getName());
		assertTrue("The number of counted entries was not correct after removing one entry!",i!=pb.countEntries());
		pb.removeMarkedEntry();
		assertEquals("After removing an entry the marked entry was not correct! If you remove the last entry set the mark to the new last entry!!","3",pb.getMarkedEntry().getPerson().getName());
	}

	public void testFirstEntry() {
		Entry e = pb.getFirstEntry();
		assertNotNull("No first entry was returned from an non empty phone book!",e);
		assertEquals("The first entry was not correct!","1",e.getPerson().getGivenName());
	}

	public void testLastEntry() {
		Entry e = pb.getLastEntry();
		assertNotNull("No last entry was returned from an non empty phone book!",e);
		assertEquals("The last entry was not correct!","5",e.getPerson().getGivenName());
	}

	public void testGetMarkedEntry() {
		pb.removeMarkedEntry();
		Entry e = pb.getMarkedEntry();
		assertNotNull("No marked entry was returned from an non empty phone book!",e);
	}

	public void testMarkNextEntry() {
		try {
			pb.markNextEntry();
			pb.getMarkedEntry();
		} catch(Exception e) {
			fail("The end of the phone book was not correctly determined while moving the mark over the entries!");
		}
	}

	public void testMarkPreviousEntry() {
		try {
			for(int i = 0;i<6;i++) {
				pb.markPreviousEntry();
			}
			pb.getMarkedEntry();
		} catch(Exception e) {
			fail("The beginning of the phone book was not correctly determined while moving the mark over the entries!");
		}
	}

}
