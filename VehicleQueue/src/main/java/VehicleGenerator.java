import java.util.Random;

public class VehicleGenerator {

	private Random randomGenerator;

	public VehicleGenerator() {
		randomGenerator = new Random();
	}

	public Vehicle createVehicle() {
		int index = randomGenerator.nextInt(3);

		switch (index) {
		case 0:
			return new Car();

		case 1:
			return new Bus();

		default:
			return new Bicycle();
		}
	}
}