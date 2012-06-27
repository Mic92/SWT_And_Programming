/**
 * Created on:
 * 20.08.2007
 *
 * 12:38:42
 * 
 * Created by:
 * Martin
 */


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class MyDeskTestCases extends TestCase {
	private MyDesk myDesk;
	private Resource res1;
	private Resource res2;
	private Resource res3;
	private ResourceType resType1;
	private ResourceType resType2;
	private ResourceType resType3;

	@Before
	public void setUp() throws Exception {
		myDesk = new MyDesk();
		resType1 = new ResourceType("txt-file", new PlainTextCollector());
		resType2 = new ResourceType("txt-file", new PlainTextCollector());
		resType3 = new ResourceType("unknown", new DefaultCollector());
		res1 = new Resource("res1.txt", "C:\\test", resType1);
		res2 = new Resource("res2.txt", "C:\\test", resType2);
		res3 = new Resource("res3.xyz", "C:\\test", resType3);
	}

	@Test
	public void testTypeRegister() {
		myDesk = new MyDesk();
		assertNull("There should not be null returned for the type null!", myDesk.getType(null));
		// test bei 0 registrierten Typen
		assertNull("There should not be null returned if there is no registert type!", myDesk.getType("txt"));
		// Test bei registrierten Typen
		myDesk.registerType("txt", resType1);
		assertEquals("The returned type doesnt match with the asked type", resType1, myDesk.getType("txt"));
		myDesk.unregisterType("txt");
		assertNull("There should not be null returned if there is no registert type!", myDesk.getType("txt"));
	}

	// Hiermit ist der Test der Klasse Index auch gleich mit abgeschlossen, da
	// über registerResource() und processRequest() diese getestet wird
	
	@Test
	public void testResourceRegisterAndProcessRequest() {
		myDesk = new MyDesk();
		assertNull("There should be returned null when no Resource is registered!", myDesk.processRequest("txt"));
		// Test der Resource, ob alles korrekt gespeichert ist.
		assertEquals("The file name should be saved correct!", "res1.txt", res1.getName());
		assertEquals("The file path should be saved correct!", "C:\\test", res1.getPath());
		assertEquals("The file type should be saved correct!", resType1, res1.getType());

		//Test ob Resource im Index auch richtig abgespeichert wird!
		myDesk.registerType("txt", resType1);
		myDesk.registerType("jpg", resType2);
		myDesk.registerResource(res1);
		myDesk.registerResource(res2);
		assertEquals("The right Resource/Resources should be returned!", 2, myDesk.processRequest("Viel").size());
		assertEquals("The wrong Resource was returned!", "res1.txt", myDesk.processRequest("Viel").get(0).getName());
		assertEquals("The wrong Resource was returned!", "res2.txt", myDesk.processRequest("Viel").get(1).getName());

	}
	@Test
	public void testKeywordCollector() {
		myDesk = new MyDesk();
		
		myDesk.registerResource(res1);
		assertTrue("The content of a Textfile should be known as a Keyword and should link to the file in which it can be found!", myDesk.processRequest("Viel").contains(res1));
		assertTrue("The content of a Textfile should be known as a Keyword and should link to the file in which it can be found!", myDesk.processRequest("Erfolg").contains(res1));
		assertTrue("The content of a Textfile should be known as a Keyword and should link to the file in which it can be found!", myDesk.processRequest("in").contains(res1));
		assertTrue("The content of a Textfile should be known as a Keyword and should link to the file in which it can be found!", myDesk.processRequest("dieser").contains(res1));
		
		myDesk.registerResource(res3);
		assertTrue("The name of a unknown file type should be known as a keyword and should link to the file in which it can be found!", myDesk.processRequest("res3.xyz").contains(res3));
	}
}
