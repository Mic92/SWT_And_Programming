

import junit.framework.TestCase;

/**
 * @author alaak
 *
 */
public class KingTest extends TestCase {

	/**
	 * Test method for {@link Inhabitant.King#tax()}.
	 */
	public void testSteuer() {
		Inhabitant ew = new King();
		
		ew.setIncome(10);
		assertEquals("The should not pay any taxes!",0,ew.tax());
		
		ew.setIncome(0);
		assertEquals("The should not pay any taxes!",0,ew.tax());
		
		ew.setIncome(-1);
		assertEquals("The should not pay any taxes!",0,ew.tax());
	}

}
