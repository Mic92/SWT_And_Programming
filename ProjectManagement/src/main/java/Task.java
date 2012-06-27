import java.util.*;

public class Task extends ProjectItem
{
    public double getMaterialsCost() {
        double cost = 0;
        for (Deliverable i: items) {
            cost += i.getMaterialsCost();
        }
        return cost;
    }

    private Set<Deliverable> items = new HashSet<Deliverable>();
    public Task(String name, String details, double rate) {
        super(name,details,rate);
    }
    public Set<Deliverable> allDeliverables() {
        return items;
    }
    public double getTimeRequired() {
        double time = 0;
        for (Deliverable i: items) {
            time += i.getTimeRequired();
        }
        return time;
    }
    public void addProjectItem (ProjectItem pi) {
        items.addAll(pi.allDeliverables());
    }
    public void removeProjectItem (ProjectItem pi) {
        items.removeAll(pi.allDeliverables());
    }
}