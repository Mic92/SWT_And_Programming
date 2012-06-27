import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 20.01.2007
 * 10:50:36
 */

/**
 * @author alaak
 *
 */
public class QueueImplTestWithoutDuplicates {
	
	private Queue<String> q;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		q = new QueueImpl<String>(false);
	}

	/**
	 * Test method for {@link QueueImpl#add(java.lang.Object)}.
	 */
	@Test
	public void testAdd() {
		assertTrue("It should be possible to add a new element to a queue without duplicates!",q.add("elem1"));
		assertEquals("After having added an element to a queue without duplicates, this element should be the front of the queue!","elem1",q.front());
		assertFalse("The method add should return false if I want to add an element twice to a queue without duplicates!",q.add("elem1"));
		assertEquals("The method remove for queues without duplicates does not work correctly!","elem1",q.remove());
		assertNull("After having added the same element twice to a queue without duplicates and removing it one time the front method should return null!",q.front());
		assertNull("It should not be possible to add an element twice to a queue without duplicates and get it twice by remove!",q.remove());
	}

}
