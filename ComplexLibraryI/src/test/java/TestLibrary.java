import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLibrary {

	private Library objectOfClassUnderTest;

	@Before
	public void setUp() throws Exception {
		objectOfClassUnderTest = Library.getTheLibrary();
		objectOfClassUnderTest.addBook("book");
		objectOfClassUnderTest.addUserAccount("user");
	}

	@After
	public void tearDown() throws Exception {
		objectOfClassUnderTest.removeBook("book");
		objectOfClassUnderTest.removeUserAccount("user");
		objectOfClassUnderTest = null;

		System.gc();
	}

	@Test
	public final void testGetTheLibrary() {
		Library lib2 = Library.getTheLibrary();

		assertSame("The method getTheLibrary of class Library should always return the same library instance!",objectOfClassUnderTest, lib2);
	}

	@Test
	public final void testBorrowBookSuccessful() {

		assertTrue("After calling borrowBook to borrow a book that is in the inventory of the library and not yet borrowed the method should return true!",objectOfClassUnderTest.borrowBook("book", "user"));
		objectOfClassUnderTest.returnBook("book", "user");

	}

	@Test
	public void testBorrowBookUnsuccessefulBecauseOfTwoMuchItemsBorrowed()
			throws Exception {
		objectOfClassUnderTest.addUserAccount("user3");
		objectOfClassUnderTest.addBook("book1");
		objectOfClassUnderTest.addBook("book2");
		objectOfClassUnderTest.addBook("book3");
		objectOfClassUnderTest.addBook("book4");
		objectOfClassUnderTest.addBook("book5");

		objectOfClassUnderTest.borrowBook("book1", "user3");
		objectOfClassUnderTest.borrowBook("book2", "user3");
		objectOfClassUnderTest.borrowBook("book3", "user3");
		objectOfClassUnderTest.borrowBook("book4", "user3");
		objectOfClassUnderTest.borrowBook("book5", "user3");
		assertTrue("It seems that returnBook does not work probperly!",objectOfClassUnderTest.returnBook("book5", "user3"));
		assertTrue("It should be possible to borrow more than five books if one book is returned before too much books are borrowed!",objectOfClassUnderTest.borrowBook("book5", "user3"));

		assertFalse("It should not be possible to borrow more than five books. Assure that the method borrowBook returns true after five books have been borrowed!",objectOfClassUnderTest.borrowBook("book", "user3"));
		objectOfClassUnderTest.returnBook("book", "user3");
		objectOfClassUnderTest.returnBook("book1", "user3");
		objectOfClassUnderTest.returnBook("book2", "user3");
		objectOfClassUnderTest.returnBook("book3", "user3");
		objectOfClassUnderTest.returnBook("book4", "user3");
		objectOfClassUnderTest.returnBook("book5", "user3");
		objectOfClassUnderTest.removeBook("book1");
		objectOfClassUnderTest.removeBook("book2");
		objectOfClassUnderTest.removeBook("book3");
		objectOfClassUnderTest.removeBook("book4");
		objectOfClassUnderTest.removeBook("book5");
		objectOfClassUnderTest.removeUserAccount("user3");
		
	}

	@Test
	public void testBorrowBookUnsuccessfulBecauseOfItemAlreadyBorrowed()
			throws Exception {
		objectOfClassUnderTest.addUserAccount("user2");

		objectOfClassUnderTest.borrowBook("book", "user2");
		assertFalse("It should not be possible to borrow a book that is already borrowed!",objectOfClassUnderTest.borrowBook("book", "user"));
		objectOfClassUnderTest.returnBook("book", "user2");
	}

	@Test
	public final void testReturnBookSuccessful() {
		objectOfClassUnderTest.borrowBook("book", "user");
		assertTrue("Returning a book should be successful for a borrowed book!",objectOfClassUnderTest.returnBook("book", "user"));
		assertTrue("After having returned a book it should be possible to borrow it again!",objectOfClassUnderTest.borrowBook("book", "user"));
		objectOfClassUnderTest.returnBook("book", "user");
	}

	@Test
	public void testReturnBookUnsuccessful() throws Exception {
		assertFalse("Returning a book should no be successful for a not borrowed book!",objectOfClassUnderTest.returnBook("book", "user"));
	}
	
	@Test
	public void testReturnBookWithNullArgument() throws Exception {
		try {
			objectOfClassUnderTest.returnBook(null,null);
			fail("Calling returnBook with a null argument should throw a NullPointerException");
		} catch(NullPointerException exception) {}
		try {
			objectOfClassUnderTest.returnBook(null, "user");
			fail("Calling returnBook with a null argument should throw a NullPointerException");
		} catch(NullPointerException exception) {}
		try {
			objectOfClassUnderTest.returnBook("book", null);
			fail("Calling returnBook with a null argument should throw a NullPointerException");
		} catch(NullPointerException exception) {}
	}
	
	@Test
	public void testRemoveBookSuccessful() throws Exception {
		objectOfClassUnderTest.addBook("book6");
		objectOfClassUnderTest.removeBook("book6");
		assertNull("A removed book should not be in the library!",objectOfClassUnderTest.getBook("book6"));
	}

}
