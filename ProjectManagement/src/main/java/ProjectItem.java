import java.util.*;

public abstract class ProjectItem {
    protected String name, description;
    protected double rate;

    ProjectItem(String name, String description, double rate) {
        this.name = name;
        this.description = description;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getRate() {
        return rate;
    }

    public void setDetails(String newDetails) {
    }

    /**
     * Diese Operation schätzt die Kosten eines Projektelements.
     * Die Kosten summieren sich aus fixen Materialkosten und dem
     * Zeitaufwand multipliziert mit der Kostenrate.
     */
    public Set<Deliverable> allDeliverables() {
        Set<Deliverable> s = new HashSet<Deliverable>();
        s.add((Deliverable) this);
        return s;
    }

    public double getCostEstimate() {
        return getTimeRequired() * rate + getMaterialsCost();
    }

    public abstract double getTimeRequired();


    public abstract double getMaterialsCost();
}