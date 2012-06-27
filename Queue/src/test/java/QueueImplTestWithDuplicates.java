import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 20.01.2007
 * 10:32:08
 */

/**
 * @author alaak
 *
 */
public class QueueImplTestWithDuplicates {
	
	private Queue<String> q;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		q = new QueueImpl<String>(true);
	}

	/**
	 * Test method for {@link QueueImpl#add(java.lang.Object)}.
	 */
	@Test
	public void testQueueing() {
		assertTrue("It should be possible to add a new element to an empty queue!",q.add("elem1"));
		assertFalse("The method isEmpty should return false for a non empty queue!",q.isEmpty());
		assertEquals("The size method does not count correctly! It should return 1 for a queue which only has one element!",1,q.size());
		assertEquals("The front of a queue should be the element added first!","elem1",q.front());
		assertTrue("It should be possible to add an element twice to a queue with duplicates!",q.add("elem1"));
		assertEquals("If I remove an element from a queue it should return the element added first!","elem1",q.remove());
		assertTrue("It should be possible to add a second element to the queue!",q.add("elem2"));
		assertEquals("The size method does not count correctly! It should return 2 for a queue which has two elements!",2, q.size());
		assertEquals("The elements are not ordered correctly by the queue!","elem1",q.front());
		assertEquals("The elements are not ordered correctly by the queue!","elem1",q.remove());
		assertEquals("The elements are not ordered correctly by the queue!","elem2", q.front());
		assertEquals("The elements are not ordered correctly by the queue!","elem2",q.remove());
		
	}
	
	@Test
	public void testEmpty() {
		assertEquals("An empty queue should have size 0!",0,q.size());
		assertTrue("The method isEmpty should return true for an empty queue!",q.isEmpty());
		assertNull("The front mehtod should return null for an emtpy queue!",q.front());
		assertNull("The remove mehtod should return null for an emtpy queue!",q.remove());
	}

}
