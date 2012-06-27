public class Purchasing extends Observation {
    ReceivingStock s;

    public Purchasing(ReceivingStock s) {
        this.s = s;
    }
    public void buy(Part t,int count) {
        s.set(t,count);
    }

    @Override
    void alarm(Part t) {
        if (s.get(t) < s.getMinStockItems()) {
            buy(t,s.getMaxStockItems());
        }
    }
}
