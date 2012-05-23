import junit.framework.TestCase;
import java.util.Map;
import java.util.TreeMap;

public class SurfaceTest extends TestCase {

	private Surface testSurface;
	private Material testFlooring, testPaint;
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() { 
         testSurface = new Surface(2.0, 10.0);
         testPaint = new Paint("Innenfarbe weiss", 50.0, 2, 10.0);
         testFlooring = new Flooring("PVC rot", 10.0, 2.0);
    } 

    public void testGetArea() { 
        assertEquals("getArea() must return correct area size", 20.0, testSurface.getArea());
    } 
    
    public void testSetMaterial() {
        testSurface.setMaterial(testPaint);
        assertEquals("setMaterial does not return correct value for Paint (10, 2)", 200.0, testSurface.getPrice());
        testSurface.setMaterial(testFlooring);
        assertEquals("setMaterial does not return correct value for Flooring (50, 2, 10)", 100.0, testSurface.getPrice());
    }
    
    public void testAddMaterialReq() {
    	Map<String, Double> expectedMap = new TreeMap<String, Double>();
    	expectedMap.put("Innenfarbe weiss", 4.0);
    	
    	testSurface.setMaterial(testPaint);
    	Map<String, Double> actualMap = testSurface.addMaterialReq(new TreeMap<String, Double>());
    	assertEquals("addMaterialReq() should return a map containing the correct material requirements", expectedMap, actualMap);
    }
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() { 
         testSurface = null;
         testPaint = null;
         testFlooring = null;
    } 

}
