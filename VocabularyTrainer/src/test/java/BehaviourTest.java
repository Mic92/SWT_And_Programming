
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/*Solution*/


public class BehaviourTest extends TestCase {
	private QuizData quizD = new QuizData();
	
	public void tearDown()
	{
		quizD = null;
		System.gc();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testQuizBehaviourInit()
	{
		Field[] fields = quizD.getClass().getDeclaredFields();
		
		for(Field f : fields)
		{
			// test vocabMap
			if(f.getName().equals("vocabMap"))
			{
				f.setAccessible(true);
				Map vMap;
				
				try  {
					vMap = (Map) f.get(quizD);
				} catch (Exception e)
				{
					fail("Be sure, that vocalMap is a java.util.Map!");
					e.printStackTrace();
					return;
				}
				
				// clear Map
				vMap.clear();
				
				// put something into
				vMap.put(1, new VocabCard("fish", "Fisch"));
				
				//holt alle Methoden
				Method[] methods = quizD.getClass().getDeclaredMethods(); 

				// Suche  der drawNext Methode, um eine current Card zu erhalten!
				for(int a=0; a<methods.length;a++) {
					if(methods[a].getName().equals("drawNext")) {
						methods[a].setAccessible(true);
						
						//ausf�hren der drawNext() Methode und current damit setzen
						try {
							methods[a].invoke(quizD);
						} catch (IllegalArgumentException e) {
							fail("Test if drawNext is implemented well!");
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							/* cannot appear */
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							fail("Somethin went wrong in the drawNext Method!");
							e.printStackTrace();
						} 
						break;
					}
				}
				
				//sucht alle Attribute!
				Field[] fields1 = quizD.getClass().getDeclaredFields(); 

				// Suchen des current Attributs
				for(int b=0;b<fields1.length;b++) {
					if(fields1[b].getName().equals("current")) {
						fields1[b].setAccessible(true);
						Object vMap2 = null;
						
						// Suchen der vocabMap um Methode getCurrentVocabCard() testen zu koennen
						for(int c=0; c<fields1.length;c++) {
							if(fields1[c].getName().equals("vocabMap")) {
								fields1[c].setAccessible(true);
								try {
									vMap2 = fields1[c].get(quizD);
								} catch (IllegalArgumentException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							}
						}
						//holen der current VocabCard durch die vom User geschriebene getCurrentVocabCard() zu testen!
						VocabCard vCardUser = quizD.getCurrentVocabCard();
						
						//Holen der current VocabCard aus der Map -> Map ist nicht zu �berpr�fen da VocabReader nicht zu impl. war.
						Object vCardTest;
						try {
							vCardTest = ((HashMap)vMap2).get(fields1[b].getInt(quizD));
						} catch (IllegalArgumentException e) {
							fail("Test if you use Maps and that vocabMap is one!");
							e.printStackTrace();
							return;
						} catch (IllegalAccessException e) {
							fail("Cannot access the Map!");
							e.printStackTrace();
							return;
						}
						
						if(vCardUser == null)
							fail("getCurrentVocabCard() returns a null value!");
						
						
						System.out.println(vCardUser.toString() + vCardTest.toString());
						assertEquals("A wrong current VocableCard was returned, check that!", vCardUser, vCardTest );
						
						//Testen ob sizeVocab correct implementiert ist
						int userSize = quizD.sizeVocab();
						int testSize = ((HashMap)vMap2).size();
						
						assertEquals("A wrong size of the vocabMap was given!",userSize, testSize);
						break;
					}
				}	
			}
		
		}
	}
}