import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 28.11.2006
 * 15:39:47
 */

/**
 * @author alaak
 *
 */
public class TestFilledBibliothek {
	
	private Bibliothek bibo;
	
	private Buch b1;
	private Buch b2;
	private Buch b3;
	private Buch b4;
	private Buch b5;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		bibo = new Bibliothek();
		
		b1 = new Buch("0","0","0");
		b2 = new Buch("1","1","1");
		b3 = new Buch("2","2","2");
		b4 = new Buch("3","3","3");
		b5 = new Buch("4","2","4");
		
		bibo.sortiertesEinfuegen(b1);
		bibo.sortiertesEinfuegen(b2);
		bibo.sortiertesEinfuegen(b3);
		bibo.sortiertesEinfuegen(b4);
		bibo.sortiertesEinfuegen(b5);
	}

	/**
	 * Test method for {@link Bibliothek#sucheNachISBN(java.lang.String)}.
	 */
	@Test
	public void testSucheNachISBN() {
		assertEquals("The method sucheNachISBN should return the correct book!",b2,bibo.sucheNachISBN("1"));
	}

	/**
	 * Test method for {@link Bibliothek#sucheNachAutor(java.lang.String)}.
	 */
	@Test
	public void testSucheNachAutor() {
		Collection test = bibo.sucheNachAutor("2");
		
		assertTrue("The collection of an authors books should contain all his books!",test.contains(b3));
		assertTrue("The collection of an authors books should contain all his books!",test.contains(b5));
		assertEquals("The collection of an authors books should contain all his books!",2,test.size());
	}

}
