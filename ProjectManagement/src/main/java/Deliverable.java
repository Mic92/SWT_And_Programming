import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Deliverable extends ProjectItem {
    private double materialsCost;
    private double productionTime;
    private Calendar date;
    public Deliverable ( String name, String details,
                         double materialsCost, double productionTime,
                         double rate, Calendar date) {
        super (name, details, rate);
        this.materialsCost = materialsCost;
        this.productionTime = productionTime;
        this.date = date;
    }
    public Calendar getDate() {
        return date;
    }
    public double getTimeRequired() {
        return productionTime;
    }
    public double getMaterialsCost() {
        return materialsCost;
    }
}