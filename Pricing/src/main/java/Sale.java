public class Sale implements DiscountType {
    private ISalePricing myPricing;
    private double preDiscountTotal = 0;
    public Sale(double preDiscountTotal) {
        this.preDiscountTotal = preDiscountTotal;
    }
    public double getTotal() {
        return myPricing.getTotal(this);
    }
    public double getPreDiscountTotal() {
        return preDiscountTotal;
    }
    public ISalePricing createPricing(int discountType,
                                      double percentage, double discount, double threshold) {
        switch(discountType) {
            case PERCENTAGEDISCOUNT:
                myPricing = new PercentageDiscountPricing(percentage);
                break;
            case ABSOLUTEDISCOUNT:
                myPricing = new AbsoluteDiscountPricing(discount,threshold);
                break;
        }
        return myPricing;
     }
    public void setPricing(ISalePricing pricing) {
        myPricing = pricing;
    }
}
