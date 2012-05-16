import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLibraryUserHandling {

	private Library objectOfClassUnderTest;

	@Before
	public void setUp() throws Exception {
		this.objectOfClassUnderTest = Library.getTheLibrary();
	}

	@After
	public void tearDown() throws Exception {
		this.objectOfClassUnderTest = null;
		System.gc();
	}

	@Test
	public final void testAddUserAccountSuccessful() {

		assertTrue(objectOfClassUnderTest
				.addUserAccount("useraccountsuccessful"));
		assertTrue(objectOfClassUnderTest
				.hasUserAccount("useraccountsuccessful"));
	}

	@Test
	public void testAddUserAccountUnsuccessfulBecauseOfSamePi()
			throws Exception {
		this.objectOfClassUnderTest.addUserAccount("user");
		assertFalse(objectOfClassUnderTest.addUserAccount("user"));
		assertTrue(objectOfClassUnderTest.hasUserAccount("user"));
		objectOfClassUnderTest.removeUserAccount("user");
	}

	@Test
	public void testAddUserAccountUnsuccessful() throws Exception {
		assertFalse(objectOfClassUnderTest.addUserAccount(null));
	}

	@Test
	public final void testRemoveUserAccountSuccessful() {
		this.objectOfClassUnderTest
				.addUserAccount("removeuseraccountsuccessful");
		assertTrue(objectOfClassUnderTest
				.removeUserAccount("removeuseraccountsuccessful"));
		assertFalse(objectOfClassUnderTest
				.hasUserAccount("removeuseraccountsuccessful"));
	}

	@Test
	public void testRemoveUserAccountUnsuccessful() throws Exception {
		assertFalse(objectOfClassUnderTest
				.removeUserAccount("removeuseraccountunsuccessful"));
		assertFalse(objectOfClassUnderTest.removeUserAccount(null));
	}

	@Test
	public final void testHasUserAccount() {
		objectOfClassUnderTest.addUserAccount("user");

		assertTrue(objectOfClassUnderTest.hasUserAccount("user"));

		objectOfClassUnderTest.removeUserAccount("user");
	}

	@Test
	public final void testHasUserAccountUnsuccessful() {
		assertFalse(objectOfClassUnderTest.hasUserAccount("pi"));
		assertFalse(objectOfClassUnderTest.hasUserAccount(null));
	}

}
