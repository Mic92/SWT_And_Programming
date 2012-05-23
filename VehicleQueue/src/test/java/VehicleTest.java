import junit.framework.TestCase;

public class VehicleTest extends TestCase {
	
	private Vehicle testVehicle;
	
	public void testBicycle() {
		testVehicle = new Bicycle();
		assertEquals("A bike must be 1.5 meters long", 1.5, testVehicle.getLength());
	}
	
	public void testBus() {
		testVehicle = new Bus();
		assertEquals("A bus must be 18 meters long", 18.0, testVehicle.getLength());
	}
	
	public void testCar() {
		testVehicle = new Car();
		assertEquals("A car must be 6 meters long", 6.0, testVehicle.getLength());		
	}
}
