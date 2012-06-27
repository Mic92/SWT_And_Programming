import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 19.01.2007
 * 19:28:12
 */

/**
 * @author alaak
 * 
 */
public class OrderedSetImplTest {

	OrderedSet<String> os;

	String s0, s1, s2, s3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		os = new OrderedSetImpl<String>(2);
		s0 = "elem0";
		s1 = "elem1";
		s2 = "elem2";
		s3 = "elem3";
	}

	/**
	 * Test method for {@link OrderedSetImpl#add(java.lang.Object)}.
	 */
	@Test
	public void testAddObject() {
		assertTrue("Adding an element to an OrderedSet should return true!", os
				.add(s1));
		assertFalse(
				"Adding an element to an OrderedSet which is already contained in this set should return false!",
				os.add(s1));
		try {
			os.add(null);
		} catch (NullPointerException npe) {
			assertNotNull(
					"Adding null to an OrderedSet should throw a null pointer exception!",
					npe);
		}
	}

	/**
	 * Test method for {@link OrderedSetImpl#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIntObject() {
		os.add(0, s0);
		os.add(1, s1);
		assertNull(
				"Setting an element of an OrderedSet to a new value should return null if this element does already exist!",
				os.set(1, s1));
		assertEquals(
				"Setting an element of an OrderedSet to a new value should return the value that was at this position before!",
				s1, os.set(1, s2));
		try {
			os.set(1, null);
		} catch (NullPointerException npe) {
			assertNotNull(
					"Setting null in an OrderedSet should throw a null pointer exception!",
					npe);
		}
	}

	/**
	 * Test method for {@link OrderedSetImpl#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntObject() {
		os.add(0, s1);
		assertTrue(
				"Adding an element to an OrderedSet should really add the element!",
				os.contains(s1));
		os.add(1, s1);

		boolean npebool = false, iooebool = false;

		try {
			os.remove(1);
		} catch (IndexOutOfBoundsException iooe) {
			iooebool = true;
		}
		try {
			os.add(0, null);
		} catch (NullPointerException npe) {
			npebool = true;
		}
		if (!npebool)
			fail("Adding null to an OrderedSet should throw a null pointer exception!");
		if (!iooebool)
			fail("It should not be possible to add an element twice to an ordered set");
	}

	/**
	 * Test method for {@link OrderedSetImpl#addAll(java.util.Collection)}.
	 */
	@Test
	public void testAddAllCollection() {
		try {
			os.addAll(new LinkedList<String>());
		} catch (UnsupportedOperationException uoe) {
			assertNotNull("The method addAll(Collection) should return an UnsupportedOperationException!");
		}
	}

	/**
	 * Test method for {@link OrderedSetImpl#addAll(int, java.util.Collection)}.
	 */
	@Test
	public void testAddAllIntCollection() {
		try {
			os.addAll(new LinkedList<String>());
		} catch (UnsupportedOperationException uoe) {
			assertNotNull("The method addAll(int,Collection) should return an UnsupportedOperationException!");
		}
	}

}
