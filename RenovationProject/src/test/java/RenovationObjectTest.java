import java.util.Map;
import java.util.TreeMap;

import junit.framework.TestCase;

public class RenovationObjectTest extends TestCase {

	private StructuredObject renovation;
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.) 
     */ 
    protected void setUp() { 
		renovation = new StructuredObject();
	}
    
    public void testFloorSurface() {
    	Surface s1 = new Surface(2.0, 3.0);
    	Material m1 = new Flooring("PVC rot", 5.0, 2.0);
    	s1.setMaterial(m1);
    	renovation.add(s1);
    	
		Map<String, Double> expectedMaterials = new TreeMap<String, Double>();
		expectedMaterials.put("PVC rot", 3.0);
		
		Map<String, Double> actualMaterials = new TreeMap<String, Double>();
		actualMaterials = renovation.addMaterialReq(actualMaterials);
			    
        assertEquals("addMaterialReq() of RenovationObject does not return correct map", expectedMaterials, actualMaterials);
        assertEquals("getPrice() of RenovationObject does not return actual price.", 15.0, renovation.getPrice());
    }

    public void testSurface() { 
        StructuredObject so1 = new StructuredObject();
		Surface s1 = new Surface(2.0, 3.0);
		Surface s2 = new Surface(3.0, 4.0);

		Material m1 = new Flooring("PVC rot", 10.0, 2.0);
		Material m2 = new Paint("Innenfarbe gruen", 50.0, 2, 10.0);

		s1.setMaterial(m1);
		s2.setMaterial(m2);

		renovation.add(s1);
		renovation.add(so1);

		so1.add(s2);
		so1.add(s2);

		Map<String, Double> expectedMaterials = new TreeMap<String, Double>();
		expectedMaterials.put("PVC rot", 3.0);
		expectedMaterials.put("Innenfarbe gruen", 2.5);		
		
		Map<String, Double> actualMaterials = new TreeMap<String, Double>();
		actualMaterials = renovation.addMaterialReq(actualMaterials);
			    
        assertEquals("addMaterialReq() of RenovationObject does not return correct map", expectedMaterials, actualMaterials);
        assertEquals("getPrice() of RenovationObject does not return actual price.", 155.0, renovation.getPrice());
    } 
  
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.) 
     */ 
    protected void tearDown() { 
         renovation = null;
    } 
}
