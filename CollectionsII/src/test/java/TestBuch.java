import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 28.11.2006
 * 14:50:35
 */

/**
 * @author alaak
 *
 */
public class TestBuch {
	
	private Buch b1;
	private Buch b2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		b1 = new Buch("0","niemand","meiner");
		b2 = new Buch("1","ich","keiner");
	}

	/**
	 * Test method for {@link Buch#compareTo(java.lang.Object)}.
	 */
	@Test
	public void testSelfCompareTo() {
		assertEquals("If a book is compared to itself it should be recognized as equal!",0,b1.compareTo(b1));
	}
	
	@Test
	public void testDifferentCompareTo() {
		assertTrue("A book with a lower isbn should be lower than a book with a higher isbn!",b1.compareTo(b2)<0);
		assertTrue("A book with a higher isbn should be higher than a book with a lower isbn!",b2.compareTo(b1)>0);
	}

	/**
	 * Test method for {@link Buch#getIsbn()}.
	 */
	@Test
	public void testGetIsbn() {
		assertEquals("ISBNs are not returned correctly!","0",b1.getIsbn());
	}

	/**
	 * Test method for {@link Buch#getAutor()}.
	 */
	@Test
	public void testGetAutor() {
		assertEquals("Autors are not returned correctly!","niemand",b1.getAutor());
	}

}
