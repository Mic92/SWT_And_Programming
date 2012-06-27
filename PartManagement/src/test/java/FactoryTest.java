import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 13.01.2007
 * 18:38:52
 */

/**
 * @author alaak
 *
 */
public class FactoryTest {

	private Factory fac;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ReceivingStock rs = new ReceivingStock(3,10);
		fac = new Factory(new Purchasing(rs),rs);
	}

	/**
	 * Test method for {@link Factory#create(int, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreate() {
		assertTrue("IPartType.COMPONENT as Parameter the create mathod of the factory should produce an object of type Components!",fac.create(IPartType.COMPONENT, "0", "a part") instanceof Components);
		assertTrue("IPartType.RESOURCE as Parameter the create mathod of the factory should produce an object of type Resource!",fac.create(IPartType.RESOURCE, "0", "a part") instanceof Resource);
		assertTrue("IPartType.SINGLE_COMPONENT as Parameter the create mathod of the factory should produce an object of type SingleComponent!",fac.create(IPartType.SINGLE_COMPONENT, "0", "a part") instanceof SingleComponent);
	}

}
