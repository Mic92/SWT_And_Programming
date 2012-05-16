/*
 * Created on 04.12.2005
 */

import junit.framework.TestCase;

public class TestPredicateStartsWith extends TestCase {
	
	PredicateStartsWith<String> psw;

	protected void setUp() throws Exception {
		psw = new PredicateStartsWith<String>();
	}

	/*
	 * Test method for 'predicateiterator.PredicateStartsWith.predicate(Object, Object)'
	 */
	public final void testPredicate() {
		
		assertTrue("Predicate 'T' doesn't match 'Test'",psw.predicate("Test","T"));
		assertTrue("Predicate 'Tes' doesn't match 'Test'",psw.predicate("Test","Tes"));
		assertTrue("Predicate 'Test' doesn't match 'Test'",psw.predicate("Test","Test"));
		
		assertFalse("Predicate 'tes' matches 'Test'",psw.predicate("Test","tes"));
		assertFalse("Predicate 'no' matches 'Test'",psw.predicate("Test","no"));
		assertFalse("Predicate 'Testen' matches 'Test'",psw.predicate("Test","Testen"));
		
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate("Test",null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,"Test"));
		
	}

}
