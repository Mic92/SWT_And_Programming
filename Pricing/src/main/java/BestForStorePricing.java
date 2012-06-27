public class BestForStorePricing extends ComplexPricing {
    public BestForStorePricing(ISalePricing pricing) {
        pricings.add(pricing);
    }
    @Override
    public double getTotal(Sale sale) {
        double highest = 0;
        for (ISalePricing p: pricings) {
            highest = Math.max(p.getTotal(sale),highest);
        }
        return highest;
    }
}
