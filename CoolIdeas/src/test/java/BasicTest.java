import java.lang.reflect.Field;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 * 
 * @author Max Leuthäuser
 */
public class BasicTest {

	protected JIdea i;

	/**
	 * Set up the Tests
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		i = new JIdea("titel", "description");
	}

	/**
	 * Test of toString method, of class JAttachment.
	 */
	@Test
	public void testIfStateExists() {
		assertTrue("Missing attribute in 'JIdea':", this.getState() != null);
	}

	/**
	 * Return the Content of the Attribute "state"
	 */
	public Object getState() {
		Class<?> c = i.getClass();

		// Get attribute state, set the mode to accessible and return the
		// content
		try {
			Field myField = c.getDeclaredField("state");
			myField.setAccessible(true);
			return myField.get(i);
		} catch (NoSuchFieldException e) {
			throw new AssertionError(
					"The class 'JIdea' had to have an attribute 'state'");
		} catch (IllegalArgumentException e) {
			throw new AssertionError(
					"There was an IllegalArgumentException while checking the class attributes of 'JIdea'");
		} catch (IllegalAccessException e) {
			throw new AssertionError(
					"There was an IllegalAccessException while checking the class attributes of 'JIdea'");
		}
	}
}
