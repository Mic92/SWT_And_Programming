/*
 * Created on 01.12.2005
 */

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

public class TestPredicateIterator extends TestCase {

	PredicateIterator<String> preditsw;
	
	Collection<String> testList;
	
	protected void setUp() throws Exception {
		testList = new LinkedList<String>();
		
		testList.add("Test1");
		testList.add("nonevalid");
		testList.add("nonevalid");
		testList.add("nonevalid");
		testList.add("Test");
		testList.add("Test1");
		
		preditsw = new PredicateIterator(testList.iterator(),new PredicateStartsWith<String>(),"T");
				
	}

	/*
	 * Test method for 'predicateiterator.PredicateStartsWith.predicate(Object, Object)'
	 */
	public void testFirstNext() {
		
		assertEquals("First element of list wasn't recognized correctly!","Test1",preditsw.next());
    }
    
    public void testIntermediateNext() {
        preditsw.next();
		assertEquals("Intermediate element of list wasn't recognized correctly!","Test",preditsw.next());
    }
    
    public void testLastNext() {
        for(int i = 0; i<2; i++) preditsw.next();
		assertEquals("Last element of list wasn't recognized correctly!","Test1",preditsw.next());
    }
    
    public void testBehindLastNext() {
		try {
            for(int i = 0; i<4; i++) {
                preditsw.next();
            }
		} catch (NoSuchElementException e) {
            return;
		}
        fail("Iterator iterates over end of list without throwing NoSuchElementException!");
		
	}
	
	public void testHasNext() {
		assertTrue("Start of List has no reported next elements!",preditsw.hasNext());
		
		for(int i = 0; i<3; i++) {
			try {
				preditsw.next();
			} catch (NoSuchElementException e) {
				break;
			}
		}
		
		assertFalse("End of list is not reported!", preditsw.hasNext());
		
	}

}
