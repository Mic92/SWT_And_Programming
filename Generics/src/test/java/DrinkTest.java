import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 21.12.2006
 * 08:36:22
 */

/**
 * @author alaak
 *
 */
public class DrinkTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testInstantiateDrink() {
		try {
			Drink d = Drink.class.newInstance();
		} catch (InstantiationException e) {
			return;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		fail("Drink should be an abstract class!");
	}
	
	@Test
	public void testInstantiateWine() {
		try {
			Drink w = Wine.class.newInstance();
		} catch (InstantiationException e) {
			return;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Wine should be an abstract class!");
	}
	
	@Test
	public void testGetRegion() {
		Drink b = new Beer("Freiberger");
		Drink ww = new WhiteWine("Dresden");
		Drink rw = new RedWine("Normandie");
		
		assertEquals("The implementation of getBrewery is not correct!","Freiberger",((Beer)b).getBrewery());
		assertEquals("The implementation of getRegion of class WhiteWine is not correct!","Dresden",((WhiteWine)ww).getRegion());
		assertEquals("The implementation of getRegion of class RedWine is not correct!","Normandie",((RedWine)rw).getRegion());
	}

}
