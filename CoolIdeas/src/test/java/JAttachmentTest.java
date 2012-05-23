import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Max Leuthäuser
 */
public class JAttachmentTest {

	JAttachment a = new JAttachment("titel", "description", new File(
			"/dev/null"));

	/**
	 * Test of toString method, of class JAttachment.
	 */
	@Test
	public void testToString() {
		String expResult = "Attachment: " + "titel" + "\n" + "description";
		assertEquals("The method 'toString' of the class JAttachment"
				+ " did not work correctly.", expResult, a.toString());
	}

	/**
	 * Test of getFile method, of class JAttachment.
	 */
	@Test
	public void testGetFile() {
		File expResult = new File("/dev/null");
		assertEquals("The method 'getFile' of the class JAttachment"
				+ " did not work correctly.", expResult, a.getFile());
	}

	/**
	 * Test of setFile method, of class JAttachment.
	 */
	@Test
	public void testSetFile() {
		File expResult = new File("/etc/X11");
		a.setFile(expResult);
		assertEquals("The method 'setFile' of the class JAttachment"
				+ " did not work correctly.", expResult, a.getFile());
	}
}
