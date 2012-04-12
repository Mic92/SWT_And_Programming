import junit.framework.TestCase;

/**
 * Created on:
 * 29.10.2006
 * 20:48:23
 */

/**
 * @author alaak
 *
 */
public class ListElementTest extends TestCase {
	
	private ListElement le1;
	private ListElement le2;
	
	public void setUp() {
		le1 = new ListElement("content");
		le2 = new ListElement("content");
		
		le1.setNext(le2);
	}

	/**
	 * Test method for {@link ListElement#getContent()}.
	 */
	public void testContent() {
		le1.setContent("anystring");
		
		assertEquals("Implement the appropriate getters and setters for the content of a list element!","anystring",le1.getContent());
		
		
	}
	
	public void testNext() {
		assertEquals("Implement the appropriate getters and setters for the following element of a list element!",le2,le1.getNext());
	}
}
