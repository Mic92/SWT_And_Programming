import junit.framework.TestCase;


public class ListTest extends TestCase {
	
	private List l;
	
	public void setUp() {
		l = new List();
	}

	public void testList() {
		l.append("content1");
		l.append("content2");
		l.append("content3");
		assertEquals("Implement a correct append and remove method within the list!","content3",l.remove("content3"));
		assertEquals("Implement a correct append and remove method within the list!","content1",l.remove("content1"));
		assertEquals("Mind the special case of a list with only one element!","content2",l.remove("content2"));
		assertNull("Mind the special case of a list with no element!",l.remove("content"));
	}
}
