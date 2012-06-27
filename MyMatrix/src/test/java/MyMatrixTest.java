import java.util.Iterator;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Max Leuthäuser
 * 
 *         This JUnit Test will perform several tests on MyMatrix. We test a
 *         filled matrix and an empty one as well.
 * 
 */
public class MyMatrixTest extends TestCase {
	MyMatrix<String> filledMatrix, emptyMatrix;
	String a, b;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		filledMatrix = new MyMatrix<String>();
		emptyMatrix = new MyMatrix<String>();
		a = "a";
		b = "b";

		// fill the matrix now
		filledMatrix.put(0, 2, a);
		filledMatrix.put(1, 3, b);
		filledMatrix.put(2, 0, a);
	}

	/**
	 * Test method for {@link MyMatrix#getRowCount()}.
	 */
	@Test
	public void testGetRowCount() {
		assertEquals(
				"The method 'getRowCount()' should return the current number of rows of the matrix!",
				3, filledMatrix.getRowCount());
		assertEquals(
				"The method 'getRowCount()' should return the current number of rows of the matrix!",
				0, emptyMatrix.getRowCount());
	}

	/**
	 * Test method for {@link MyMatrix#getColumnCount()}.
	 */
	@Test
	public void testGetColumnCount() {
		assertEquals(
				"The method 'getColumnCount()' should return the current number of columns of the matrix!",
				4, filledMatrix.getColumnCount());
		assertEquals(
				"The method 'getColumnCount()' should return the current number of columns of the matrix!",
				0, emptyMatrix.getColumnCount());
	}

	/**
	 * Test method for {@link MyMatrix#getObjectCount()}.
	 */
	@Test
	public void testGetObjectCount() {
		assertEquals(
				"The method 'getObjectCount()' should return the current number of object which are currently stored in the matrix!",
				3, filledMatrix.getObjectCount());
		assertEquals(
				"The method 'getObjectCount()' should return the current number of object which are currently stored in the matrix!",
				0, emptyMatrix.getObjectCount());
	}

	/**
	 * Test method for {@link MyMatrix#getDistinctObjectCount()}.
	 */
	@Test
	public void testGetDistinctObjectCount() {
		assertEquals(
				"The method 'getDistinctObjectCount()' should return the current number of object which are currently stored in the matrix but without counting the same object twice!",
				2, filledMatrix.getDistinctObjectCount());
		assertEquals(
				"The method 'getDistinctObjectCount()' should return the current number of object which are currently stored in the matrix but without counting the same object twice!",
				0, emptyMatrix.getDistinctObjectCount());
	}

	/**
	 * Test method for {@link MyMatrix#iterator()}.
	 */
	@Test
	public void testIterator() {
		assertEquals(
				"The iterator which is returned by 'iterator()' should be a 'DepthFirstIterator'!",
				"DepthFirstIterator", filledMatrix.iterator().getClass()
						.getSimpleName());

		Iterator<String> i = filledMatrix.iterator();
		assertTrue(
				"'hasNext()' in your 'DepthFirstIterator' should return 'true' if there is a next available element.",
				i.hasNext());
		assertEquals(
				"'next()' in your 'DepthFirstIterator' should return the next element if 'hasNext()' was executed and returned 'true'.",
				"a", i.next());
		assertTrue(
				"'hasNext()' in your 'DepthFirstIterator' should return 'true' if there is a next available element.",
				i.hasNext());
		assertEquals(
				"'next()' in your 'DepthFirstIterator' should return the next element if 'hasNext()' was executed and returned 'true'.",
				"a", i.next());
		assertTrue(
				"'hasNext()' in your 'DepthFirstIterator' should return 'true' if there is a next available element.",
				i.hasNext());
		assertEquals(
				"'next()' in your 'DepthFirstIterator' should return the next element if 'hasNext()' was executed and returned 'true'.",
				"b", i.next());
		assertFalse(
				"'hasNext()' in your 'DepthFirstIterator' should return 'false' if there is no next element.",
				i.hasNext());
	}

	/**
	 * Test method for {@link MyMatrix#get(int, int)}.
	 */
	@Test
	public void testGet() {
		assertEquals(
				"The method 'get(int, int)' of your matrix should return the correct object at the given position!",
				a, filledMatrix.get(0, 2));
		assertEquals(
				"The method 'get(int, int)' of your matrix should return 'null' of there is no object at the given legal position!",
				null, filledMatrix.get(1, 2));

		try {
			filledMatrix.get(0, 4);
		} catch (IllegalArgumentException e) {
			return;
		}
		fail("The method 'get(int, int)' of your matrix should throw an 'IllegalArgumentException' if the given position is out of bounds!");
	}

	/**
	 * Test method for {@link MyMatrix#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains() {
		assertTrue(
				"The method 'contains(java.lang.Object)' of your matrix should return 'true' if the matrix contains the given object!",
				filledMatrix.contains(a));
		assertFalse(
				"The method 'contains(java.lang.Object)' of your matrix should return 'false' if the matrix does not contain the given object!",
				filledMatrix.contains("c"));
		assertFalse(
				"The method 'contains(java.lang.Object)' of your matrix should return 'false' if the matrix does not contain the given object!",
				emptyMatrix.contains(a));
	}

	/**
	 * Test method for {@link MyMatrix#put(int, int, java.lang.Object)}.
	 */
	@Test
	public void testPut() {
		assertEquals(
				"The method 'put(int, int, java.lang.Object)' of your matrix should return the old object if it is replaced by a new one!",
				a, filledMatrix.put(2, 0, b));
		assertEquals(
				"The method 'put(int, int, java.lang.Object)' of your matrix should return the old object if it is replaced by a new one! Return 'null' if nothing is replaced.",
				null, emptyMatrix.put(0, 0, a));
	}

}
