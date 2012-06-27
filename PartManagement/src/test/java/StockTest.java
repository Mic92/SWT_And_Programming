import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 13.01.2007
 * 18:52:48
 */

/**
 * @author alaak
 *
 */
public class StockTest {
	
	private Purchasing purch;
	private ReceivingStock rs;
	private Factory f;
	Part p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rs = new ReceivingStock(2,10);
		purch = new Purchasing(rs);
		f = new Factory(purch,rs);
		p = f.create(IPartType.SINGLE_COMPONENT, "0", "A Single Components");
		
		rs.insert(p, 4);
	}
	
	@Test
	public void testDelete() {
		assertFalse("It was possible to delete an item which actually is not in the stock!",rs.delete(f.create(IPartType.RESOURCE,"1","A Resource Components"), 1));
		assertFalse("It was posible to delete a wrong count of items in the stock!",rs.delete(p, 20));
		assertTrue("It was not possible to delete an item in the stock!",rs.delete(p, 1));
	}
	
	@Test
	public void testGet() {
		assertEquals("The method get seems to be implemented wrong! It returned did not return -1 for a part not in the stock!",-1,rs.get(f.create(IPartType.RESOURCE,"1","A Resource Components")));
		assertEquals("The method get seems to be implemented wrong! It returned not the actual value for a part in the stock!",4,rs.get(p));
	}
	
	@Test
	public void testSet() {
		assertFalse("Setting the count of parts which are not in a stock was possible or returned a wrong state!",rs.set(f.create(IPartType.RESOURCE,"1","A Resource Components"),5));
		assertTrue("Setting the count of parts which are in a stock was not possible or returned a wrong state!",rs.set(p,5));
		assertEquals("Setting the parts in a stock to a different value has not changed the amount returned by the get method!",5,rs.get(p));
		
	}
	
	@Test
	public void testObserver() {
		rs.register(purch);
		rs.delete(p, 3);
		assertEquals("It seems your observer is not implemented correctly!",10,rs.get(p));
	}

}
