

public class FullPhoneBookTest extends FilledPhoneBookTest {

	public void setUp() throws Exception {
		maxEntries = 5;
		super.setUp();
	}

	public void testAddNewEntry() {
		boolean actualValue = true;
		try {
			actualValue = pb.addNewEntry(new TelephoneNumber("6","6"), new Person("6","6","6"), new Address("6","6","6","6","6"));
		} catch(Exception e) {
			fail("An Exception was thrown while adding a new entry to an already full phone book! Please make sure that it will not be possible to do this!");
		}
		assertFalse("While adding a new entry it seems it was added altough the phone book was already full! Please make sure to return the correct boolean value!",actualValue);
	}

	public void testCountEntries() {
		assertEquals("Number of Entries counted was not correct!",5,pb.countEntries());
	}

	public void testGetLastEntry() {
		Entry e = pb.getLastEntry();
		assertEquals("The last entry was not correct when the phone book was full!","5",e.getAddress().getAdditionalInformation());
	}

	public void testMarkNextEntry() {
		try {
			pb.markNextEntry();
			pb.markNextEntry();
			pb.markNextEntry();
			pb.markNextEntry();
			pb.markNextEntry();
			pb.markNextEntry();
		} catch(Exception e) {
			e.printStackTrace();
			fail("An exception was cought while iterating over the end while the phone book was full!");
		}
		
	}
}
