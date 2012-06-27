import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class BonusTaskTest {

	public VocabReader vocabReader;
	public String testString1;
	public String testString2;
	
	
	@Before
	public void setUp() throws Exception {
		vocabReader = new VocabReader();
		testString1 = "#test:comment";
		testString2 = "test:vocab";
	}

	@Test
	public void createVocabCardTest() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method[] methods = vocabReader.getClass().getDeclaredMethods();
		VocabCard test1 = null;
		VocabCard test2 = null;
		for(int a=0; a<methods.length;a++) {
			if(methods[a].getName().equals("createVocabCard")) {
				methods[a].setAccessible(true);
				test1 = (VocabCard)methods[a].invoke(vocabReader, testString1);
				test2 = (VocabCard)methods[a].invoke(vocabReader, testString2);
			}
		}
		assertNull("Comments or empty lines should be ignored!",test1);
		VocabCard vcardTestObject = new VocabCard("test","vocab");
		assertEquals("Your VocabCard was not correct created!",vcardTestObject.getLang1(), test2.getLang1());
		assertEquals("Your VocabCard was not correct created!",vcardTestObject.getLang2(), test2.getLang2());
	}
	
	@Test
	public void readTest() {
		Map<Integer, VocabCard> testMap = vocabReader.read();
	}
}
