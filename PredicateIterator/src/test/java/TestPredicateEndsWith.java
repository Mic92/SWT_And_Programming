/*
 * Created on 04.12.2005
 */

import junit.framework.TestCase;

public class TestPredicateEndsWith extends TestCase {
	
	PredicateEndsWith<String> psw;

	protected void setUp() throws Exception {
		psw = new PredicateEndsWith<String>();
	}

	/*
	 * Test method for 'predicateiterator.PredicateStartsWith.predicate(Object, Object)'
	 */
	public final void testPredicate() {
		
		assertTrue("Predicate 't' doesn't match 'Test'",psw.predicate("Test","t"));
		assertTrue("Predicate 'est' doesn't match 'Test'",psw.predicate("Test","est"));
		assertTrue("Predicate 'Test' doesn't match 'Test'",psw.predicate("Test","Test"));
		
		assertFalse("Predicate 'esT' matches 'Test'",psw.predicate("Test","esT"));
		assertFalse("Predicate 'no' matches 'Test'",psw.predicate("Test","no"));
		assertFalse("Predicate 'notTest' matches 'Test'",psw.predicate("Test","Testen"));
		
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate("Test",null));
		assertFalse("Predicate shouldn't accept null Parameters", psw.predicate(null,"Test"));
	}

}
