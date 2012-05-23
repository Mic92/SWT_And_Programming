import junit.framework.TestCase;

public class VehicleQueueTest extends TestCase {

	static Time myTime = Time.getInstance();

	public void testVehicleQueue() {
		VehicleQueue queue = new VehicleQueue(0.2, 50, 0.5,  new VehicleGenerator());
        myTime.addObserver(queue);
        myTime.initEndOfTime(70);
        assertEquals("Time object must be initialized with 0", 0, myTime.getCurrentTime());
        myTime.run();
        assertEquals("Time object should stop with endOfTime limit set using initEndOfTime()", 70, myTime.getCurrentTime());
	}
}
