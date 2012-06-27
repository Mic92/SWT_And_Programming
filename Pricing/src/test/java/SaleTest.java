import junit.framework.TestCase;

public class SaleTest extends TestCase implements DiscountType {

	private Sale myTestSale;
	private static double preDiscountTotal = 10.0;
	private static double preDiscountTotal2 = 200.0;
		
	public void testPreDiscountTotal() {
		myTestSale = new Sale(preDiscountTotal);
		assertEquals("getPreDiscountTotal() of Class Sale must return value passed to constructor.", preDiscountTotal, myTestSale.getPreDiscountTotal());
	}
	
	public void testPreDiscountTotal2() {
		myTestSale = new Sale(preDiscountTotal2);
		assertEquals("getPreDiscountTotal() of Class Sale must return value passed to constructor.", preDiscountTotal2, myTestSale.getPreDiscountTotal());		
	}
	
	protected void tearDown() {
		myTestSale = null;
	}
}
