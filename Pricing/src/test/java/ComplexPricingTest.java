import junit.framework.TestCase;

public class ComplexPricingTest extends TestCase implements DiscountType {

	private Sale testSale;
	private ISalePricing p1, p2, p3, p4,p5;
	
	protected void setUp() {
		testSale = new Sale(100.0);
		p1 = testSale.createPricing(PERCENTAGEDISCOUNT,10.0,0,0); //90
		p2 = testSale.createPricing(PERCENTAGEDISCOUNT,5.0,0,0); // 95
		p3 = testSale.createPricing(ABSOLUTEDISCOUNT,0,5,50);  //95
		p4 = testSale.createPricing(ABSOLUTEDISCOUNT,0,30,90); //100
		p5 = testSale.createPricing(ABSOLUTEDISCOUNT,0,19,80); //81
	}
	
	public void testBestForCustomerPricing() {
		BestForCustomerPricing p = new BestForCustomerPricing(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		testSale.setPricing(p);
		assertEquals("BestForCustomerPricing getTotal() returns wrong price.", 81.0, testSale.getTotal());
	}
	
	public void testBestForStorePricing() {
		BestForStorePricing p = new BestForStorePricing(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		testSale.setPricing(p);
		assertEquals("BestForStorePricing getTotal() returns wrong price.", 95.0, testSale.getTotal());
	}
	
}
