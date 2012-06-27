public class AbsoluteDiscountPricing implements ISalePricing {
    private double discount,threshold;
    public AbsoluteDiscountPricing(double discount, double threshold) {
        this.discount = discount;
        this.threshold = threshold;
    }

    public double getTotal(Sale sale) {
        double price = sale.getPreDiscountTotal();
        if (price < threshold) {
            return price;
        } else if (price - discount < threshold) {
            return threshold;
        }
        return price - discount;
    }
}
