import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * Created on:
 * 28.11.2006
 * 14:49:10
 */

/**
 * @author alaak
 *
 */
public class TestEmptyBibliothek {

	private Bibliothek bibo;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bibo = new Bibliothek();
	}
	
	@Test
	public void testSucheNachISBN() {
		assertNull("Searching in an empty library should return null!",bibo.sucheNachISBN("0"));
	}
	
	@Test
	public void testSucheNachAutor() {
		assertTrue("Searching for any authors books should return an empty collection for an empty library!",bibo.sucheNachAutor("irgendjemand").isEmpty());
	}
	
	@Test
	public void testIfBestandIsList() {
		try {
			assertEquals("The field bestand is not of type Set!",Set.class,bibo.getClass().getDeclaredField("bestand").getType());
		} catch(NoSuchFieldException nsfe) {
			fail("The field bestand is not present or was not named correctly!");
		}
	}
	
	@Test
	public void testBestandNachAutorAuflisten() {
		assertTrue("The method bestandNachAutorAuflisten should return an empty map if the library is empty!",bibo.bestandNachAutorAuflisten().isEmpty());
	}

}
