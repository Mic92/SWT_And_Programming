import java.util.*;
public abstract class ComplexPricing implements ISalePricing {
    protected List<ISalePricing> pricings = new ArrayList<ISalePricing>();
    public void add(ISalePricing pricing) {
        pricings.add(pricing);
    }
}