public class PercentageDiscountPricing implements ISalePricing {
    double percentage;
    public PercentageDiscountPricing(double percentage) {
        this.percentage = percentage;
    }
    public double getTotal(Sale sale){
        return (100 - percentage) * sale.getPreDiscountTotal() / 100;
    }
}
