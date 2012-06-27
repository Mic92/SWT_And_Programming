public class SaleApp {
    public final static int PERCENTAGEDISCOUNT = 1, ABSOLUTEDISCOUNT = 2;
    public static void main (String[] args) {
        Sale sale1 = new Sale(100.0);
        ISalePricing p1, p2, p3, p4,p5;
        p1 = sale1.createPricing(PERCENTAGEDISCOUNT,10.0,0,0);
        p2 = sale1.createPricing(PERCENTAGEDISCOUNT,5.0,0,0);
        p3 = sale1.createPricing(ABSOLUTEDISCOUNT,0,5,50);
        p4 = sale1.createPricing(ABSOLUTEDISCOUNT,0,30,150);
        p5 = sale1.createPricing(ABSOLUTEDISCOUNT,0,19,80);
        BestForCustomerPricing p = new BestForCustomerPricing(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);
        sale1.setPricing(p);
        System.out.println("BestForCustomer Price = " +
                sale1.getTotal() + " EUR");
    }
}
