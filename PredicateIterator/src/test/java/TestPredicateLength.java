/*
 * Created on 04.12.2005
 */

import junit.framework.TestCase;

public class TestPredicateLength extends TestCase {
	
	PredicateLength<String> psw;

	protected void setUp() throws Exception {
		psw = new PredicateLength<String>();
	}

	/*
	 * Test method for 'predicateiterator.PredicateStartsWith.predicate(Object, Object)'
	 */
	public final void testPredicate() {
		
		assertTrue("Empty String doesn't match empty String",psw.predicate("", "0"));
        assertTrue("Empty String doesn't match empty String",psw.predicate(new String(),"0"));
        assertTrue("Empty String doesn't match empty String",psw.predicate(new String(""),"0"));
		assertTrue("Predicate 'Test' doesn't match 'Test'",psw.predicate("Test","4"));
		
		assertFalse("Predicate 'Testen' matches 'Test'",psw.predicate("Test","6"));
		
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate("Test",null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,"0"));
	}

}
