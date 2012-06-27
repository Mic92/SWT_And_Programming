import junit.framework.TestCase;

public class AbsoluteDiscountPricingTest extends TestCase implements DiscountType {

	private Sale myTestSale;

	protected void setUp() {
		myTestSale = new Sale(200.0);
	}
	
	protected void tearDown() {
		myTestSale = null;
	}

	public void testAbsoluteDiscount() {
		ISalePricing newPricing = myTestSale.createPricing(ABSOLUTEDISCOUNT, 0, 20.0, 100.0);
		myTestSale.setPricing(newPricing);
		assertEquals("Absolute discount not granted?", 180.0, myTestSale.getTotal());
	}

	public void testAbsoluteDiscountLimitBefore() {
		ISalePricing newPricing = myTestSale.createPricing(ABSOLUTEDISCOUNT, 0, 20.0, 250.0);
		myTestSale.setPricing(newPricing);
		assertEquals("Absolute discount - watch threshold!", 200.0, myTestSale.getTotal());
	}

	public void testAbsoluteDiscountLimitAfter() {
		ISalePricing newPricing = myTestSale.createPricing(ABSOLUTEDISCOUNT, 0, 20.0, 190.0);
		myTestSale.setPricing(newPricing);
		assertEquals("Absolute discount - watch threshold!", 190.0, myTestSale.getTotal());
	}

	
}
