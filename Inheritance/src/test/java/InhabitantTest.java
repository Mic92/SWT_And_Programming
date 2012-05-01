

import junit.framework.TestCase;

/**
 * @author alaak
 *
 */
public class InhabitantTest extends TestCase {

	/**
	 * Test method for {@link Inhabitant.Inhabitant#taxedIncome()}.
	 */
	public void testZuVersteuerndesEinkommen() {
		Inhabitant ew = new Inhabitant();
		
		ew.setIncome(0);
		assertEquals("Taxed income is not equal to income!",0,ew.taxedIncome());
		
		ew.setIncome(10);
		assertEquals("Taxed income is not equal to income!",10,ew.taxedIncome());
		
		ew.setIncome(-1);
		assertEquals("Taxed income is not equal to income!",-1,ew.taxedIncome());
		
		//fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link Inhabitant.Inhabitant#tax()}.
	 */
	public void testSteuer() {
		Inhabitant ew = new Inhabitant();
		
		ew.setIncome(0);
		assertEquals("Taxes are not at least one!",1,ew.tax());
		
		ew.setIncome(10);
		assertEquals("Taxes were not 10% of taxed income!",1,ew.tax());
	}

}
