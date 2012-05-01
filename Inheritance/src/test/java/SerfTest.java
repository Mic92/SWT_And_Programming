

import junit.framework.TestCase;

/**
 * @author alaak
 *
 */
public class SerfTest extends TestCase {

	/**
	 * Test method for {@link Inhabitant.Serf#taxedIncome()}.
	 */
	public void testZuVersteuerndesEinkommen() {
		Inhabitant ew = new Serf();
		
		ew.setIncome(11);
		assertEquals("Taxed income of a serf should never fall below 0!",0,ew.taxedIncome());
		
		ew.setIncome(12);
		assertEquals("A serf should have 12 Taler tax freed!",0,ew.taxedIncome());
		
		ew.setIncome(13);
		assertEquals("Taxed income of serf was not correct!",1,ew.taxedIncome());
	}

}
