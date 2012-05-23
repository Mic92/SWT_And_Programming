import junit.framework.TestCase;

public class VehicleGeneratorTest extends TestCase {

	private VehicleGenerator testGenerator;
	private Vehicle testVehicle;
	
	// I have no idea what to actually test here...
	public void testVehicleGenerator() {
		testGenerator = new VehicleGenerator();
		testVehicle = testGenerator.createVehicle();
	}
}
