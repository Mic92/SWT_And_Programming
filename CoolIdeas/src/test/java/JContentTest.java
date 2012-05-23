import java.lang.reflect.Modifier;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * @author Max Leuthäuser
 */
public class JContentTest {

	JContentImpl c = new JContentImpl();

	/**
	 * Test if JContent is abstract.
	 * 
	 */
	@Test
	public void testInstantiateJContent() {
		assertTrue("JContent should be abstract!", Modifier.isAbstract(JContent.class.getModifiers()));
	}

	/**
	 * Test of getDescription method, of class JContent.
	 */
	@Test
	public void testGetDescription() {
		assertEquals("The method 'getDescription' of the class JContent"
				+ " did not work correctly.", "description", c.getDescription());
	}

	/**
	 * Test of setDescription method, of class JContent.
	 */
	@Test
	public void testSetDescription() {
		c.setDescription("newDescription");
		assertEquals("The method 'setDescription' of the class JContent"
				+ " did not work correctly.", "newDescription",
				c.getDescription());
	}

	/**
	 * Test of getTitel method, of class JContent.
	 */
	@Test
	public void testGetTitel() {
		assertEquals("The method 'getTitel' of the class JContent"
				+ " did not work correctly.", "titel", c.getTitel());
	}

	/**
	 * Test of setTitel method, of class JContent.
	 */
	@Test
	public void testSetTitel() {
		c.setTitel("newTitel");
		assertEquals("The method 'setDescription' of the class JContent"
				+ " did not work correctly.", "newTitel", c.getTitel());
	}

	public class JContentImpl extends JContent {

		public JContentImpl() {
			super("titel", "description");
		}
	}
}
