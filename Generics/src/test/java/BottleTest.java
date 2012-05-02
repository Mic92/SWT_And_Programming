import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 21.12.2006
 * 08:58:35
 */

/**
 * @author alaak
 *
 */
public class BottleTest {
	
	Beer d;
	Bottle<Beer> bottle;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new Beer("Hasseröder");
		bottle = new Bottle<Beer>();
	}

	/**
	 * Test method for {@link Bottle#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue("The method isEmpty of class bottle should return true if the bottle is empty!",bottle.isEmpty());
	}

	/**
	 * Test method for {@link Bottle#fill(Drink)}.
	 */
	@Test
	public void testFill() {
		try {
			bottle.fill(d);
		} catch(Exception e) {
			e.printStackTrace();
			fail("Some error occured while calling the method fill of class bottle!");
		}
	}

	/**
	 * Test method for {@link Bottle#empty()}.
	 */
	@Test
	public void testEmpty() {
		bottle.fill(d);
		Beer test = bottle.empty();
		
		assertEquals("The method empty should return the same beer which was put into the bottle!",d,test);
	}

}
