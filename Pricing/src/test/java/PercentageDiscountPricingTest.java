import junit.framework.TestCase;

public class PercentageDiscountPricingTest extends TestCase implements DiscountType {

	private Sale myTestSale;

	protected void setUp() {
		myTestSale = new Sale(200.0);
	}
	
	protected void tearDown() {
		myTestSale = null;
	}
	private void testPercentage(double percentage) {
		ISalePricing newPricing = myTestSale.createPricing(PERCENTAGEDISCOUNT, percentage, 0, 0);
		myTestSale.setPricing(newPricing);
		assertEquals("Percentage discount not granted?", 200 - 200*percentage/100, myTestSale.getTotal());
	}

	public void testPercentageDiscount() {
		testPercentage(10.0);
		testPercentage(20.0);
	}

}
