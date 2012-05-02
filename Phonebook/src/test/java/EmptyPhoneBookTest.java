import junit.framework.TestCase;

public class EmptyPhoneBookTest extends TestCase {
	
	private PhoneBook phoneBookUnderTest;

	public void setUp() throws Exception {
		phoneBookUnderTest = new PhoneBook(21);
	}

	public void testAddNewEntry() {
		boolean actualValue = phoneBookUnderTest.addNewEntry(new TelephoneNumber("0","1"), new Person("Test","Test","Test"), new Address("test","1","2","Test","Test"));
		Entry e = phoneBookUnderTest.getMarkedEntry();
		String s = e.getPerson().getTitle();
		assertEquals("It seems there was some problem by adding a new entry to an empry phone book! It did not return the correct entry","Test",s);
		assertTrue("It seems it was not possible to add a new entry to an empty phone book! The method addNewEntry should return true!",actualValue);
		
	}

	public void testRemoveMarkedEntry() {
		boolean actualValue = phoneBookUnderTest.removeMarkedEntry();
		assertFalse("It seems that it was possible to remove an entry from an empty phone book! The method removeMarkedEntry should return false!",actualValue);
	}

	public void testCountEntries() {
		int actualValue = phoneBookUnderTest.countEntries();
		assertEquals("The empty phone book did not contain zero entries!",0,actualValue);
	}

	public void testFirstEntry() {
		Entry actualValue = phoneBookUnderTest.getFirstEntry();
		assertNull("The first entry of the empty phone book was not null!",actualValue);
	}

	public void testLastEntry() {
		Entry actualValue = phoneBookUnderTest.getLastEntry();
		assertNull("The last entry of the empty phone book was not null!",actualValue);
	}

	public void testGetMarkedEntry() {
		Entry actualValue = phoneBookUnderTest.getMarkedEntry();
		assertNull("The marked entry of the empty phone book was not null!",actualValue);
	}

}
