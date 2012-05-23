
/**
 *
 * @author Max Leuthäuser
 */
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StatePatternTest {
    String stateClass = "JState";
    String methodeDiscuss = "discuss";
    String methodeEvaluate = "evaluate";
    String methodeHold = "hold";
    String methodeRelease = "release";
    String methodeDecline = "decline";
	protected JIdea i;

    @Before
    public void setUp() throws Exception {
        i = new JIdea("titel", "description");
    }
	
	public boolean searchForInnerClass(String clas) {
		try {
			Class thisClass = Class.forName("JIdea");
			Class[] classes = thisClass.getDeclaredClasses();
			for(Class c : classes) {
				if(c.getName().contains(clas)) return true;
			}
			return false;
		} catch (ClassNotFoundException ex) {
			return false;
		}	
	}
	
	public boolean searchForMethod(String clas, String method, Class[] args) {
		try {
			Class thisClass = Class.forName("JIdea");
			Class[] classes = thisClass.getDeclaredClasses();
			for(Class c : classes) {
				if(c.getName().contains(clas)) {
					// search method
					try	{
						c.getMethod(method, args);
						return true;
					} catch (NoSuchMethodException ex) {
						return false;
					}
				}
			}
			return false;
		} catch (ClassNotFoundException ex) {
			return false;
		}
	}

    @Test
    public void testJIdeaClasses() {
        assertTrue("You should use the State Pattern to solve this task.", searchForInnerClass(stateClass));
		Class[] args1 = new Class[1];
		args1[0] = String.class;
        assertTrue("You should implement the state method 'discuss'", searchForMethod("JState", methodeDiscuss, args1));
		Class[] args2 = new Class[1];
		args2[0] = JValuation.class;		
        assertTrue("You should implement the state method 'evaluate'", searchForMethod("JState", methodeEvaluate, args2));
        assertTrue("You should implement the state method 'hold'", searchForMethod("JState", methodeHold, null));
        assertTrue("You should implement the state method 'release'", searchForMethod("JState", methodeRelease, null));
        assertTrue("You should implement the state method 'decline'", searchForMethod("JState", methodeDecline, null));
    }
}
