import junit.framework.TestCase;

public class FlooringTest extends TestCase {
   
	private Flooring testFlooring;
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() { 
         testFlooring = new Flooring("PVC rot", 10.0, 2.0);
    } 

    public void testGetWidth() { 
        assertEquals("getWidth() should return width set by constructor", 2.0, testFlooring.getWidth());
    } 
    
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() { 
         testFlooring = null;
    } 
}
