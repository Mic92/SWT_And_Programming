

import junit.framework.TestCase;

/**
 * @author alaak
 *
 */
public class NobelTest extends TestCase {
	
	public void testSteuer() {
		Inhabitant ew = new Nobel();
		ew.setIncome(199);
		assertEquals("Nobels taxes were not at least 20 Taler!",20,ew.tax());
		
		ew.setIncome(0);
		assertEquals("Nobels taxes were not at least 20 Taler!",20,ew.tax());
		
		ew.setIncome(-1);
		assertEquals("Nobels taxes were not at least 20 Taler!",20,ew.tax());
		
		ew.setIncome(300);
		assertEquals("Nobels taxes were not 10% of taxed income!",30,ew.tax());
	}
	
}
