import junit.framework.TestCase;

public class PaintTest extends TestCase {

	private Paint testPaint;
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() { 
         testPaint = new Paint("Innenfarbe weiss", 50.0, 2, 10.0);
    } 

    public void testGetNoOfCoats() { 
        assertEquals("getNoOfCoats() should return number of coats set by constructor", 2, testPaint.getNoOfCoats());
    } 
    
    public void testGetNoOfSqMPerLiter() {
        assertEquals("getNoOfCoats() should return number of square meter per liter set by constructor", 10.0, testPaint.getNoOfSqMPerLiter());    	
    }
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() { 
         testPaint = null;
    } 

}
