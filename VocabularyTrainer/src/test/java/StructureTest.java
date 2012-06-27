import java.lang.reflect.Field;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test for Structure
 * @author Jens Grünberg
 *
 */
public class StructureTest extends TestCase {
	private QuizData quizD = new QuizData();;
	
	public void tearDown()
	{
		quizD = null;
		System.gc();
	}
	
	@Test
	public void testQuizInit()
	{
		Field[] fields = quizD.getClass().getDeclaredFields();
		
		for(Field f : fields)
		{
			// test vocabMap
			if(f.getName().equals("vocabMap"))
			{
				f.setAccessible(true);
				
				try {
					Object vMap = f.get(quizD);
					
					/* Test if vocabMap == null  */
					if(vMap == null)
						fail("You forgot to initialize your attribute vocabMap! Please check your constructor and be sure that vocabMap is not null after initialization!");
					
				} catch (IllegalArgumentException e) {
					fail("Test if you implemented the attribute vocabMap well");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					fail("Test if you implemented the attribute vocabMap well");
					e.printStackTrace();
				}
			}
			if(f.getName().equals("cardDrawing"))
			{
				f.setAccessible(true);
				
				try {
					Object vCard = f.get(quizD);
					
					/* Test if vCard == null  */
					if(vCard == null)
						fail("You forgot to initialize your attribute cardDrawing! Please check your constructor and be sure that cardDrawing is not null after initialization!");
				} catch (IllegalArgumentException e) {
					fail("Test if you implemented the attribute cardDrawing well");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					fail("Test if you implemented the attribute cardDrawing well");
					e.printStackTrace();
				}
			}
		}
	}
}


