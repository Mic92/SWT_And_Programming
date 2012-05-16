import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLibraryBookHandling {

	private Library objectOfClassUnderTest;

	@Before
	public void setUp() throws Exception {
		objectOfClassUnderTest = Library.getTheLibrary();
	}

	@After
	public void tearDown() throws Exception {
		objectOfClassUnderTest = null;

		System.gc();
	}

	@Test
	public void testAddBook() throws Exception {
		assertTrue(objectOfClassUnderTest.addBook("book"));
		objectOfClassUnderTest.removeBook("book");

	}

	@Test
	public void testGetBookSuccessful() throws Exception {
		objectOfClassUnderTest.addBook("book");
		assertEquals("book", objectOfClassUnderTest.getBook("book"));
		objectOfClassUnderTest.removeBook("book");

	}

	@Test
	public void testGetBookUnsuccessful() throws Exception {
		assertNull(objectOfClassUnderTest.getBook("getbookunsuccessful"));
	}

	@Test
	public void testRemoveBookSuccessful() throws Exception {
		this.objectOfClassUnderTest.addBook("book");
		assertTrue(objectOfClassUnderTest.removeBook("book"));
	}

	@Test
	public void testRemoveBookUnsuccessful() throws Exception {
		assertFalse(objectOfClassUnderTest.removeBook("removebookunsuccessful"));
	}
}
