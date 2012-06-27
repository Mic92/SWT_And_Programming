public class BestForCustomerPricing extends ComplexPricing {
    public BestForCustomerPricing(ISalePricing pricing) {
        pricings.add(pricing);
    }
    public double getTotal(Sale sale) {
        double lowest = Integer.MAX_VALUE;
        for (ISalePricing p: pricings) {
            lowest = Math.min(p.getTotal(sale),lowest);
        }
        return lowest;
    }
}
