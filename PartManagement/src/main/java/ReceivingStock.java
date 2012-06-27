public class ReceivingStock extends Stock {
    int minStockItems, maxStockItems;

    public ReceivingStock(int minStockItems, int maxStockItems) {
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
    }

    public int getMinStockItems() {
        return minStockItems;
    }

    public int getMaxStockItems() {
        return maxStockItems;
    }
}
