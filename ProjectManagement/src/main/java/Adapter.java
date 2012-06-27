import java.util.ArrayList;
import java.util.List;

public class Adapter implements IProject {
    Project p;

    public Adapter(String name, String description, double rate) {
        this.p = new Project(name,description,rate);
    }

    @Override
    public double getDuration() {
        return p.getDuration();
    }

    @Override
    public double getTotalCost() {
        return p.getTotalCost();
    }

    @Override
    public List<Deliverable> getDeliverables() {
        List<Deliverable> l = new ArrayList<Deliverable>();
        for (List<Deliverable> d: p.allDeliverables().values()) {
           l.addAll(d);
        }
        return l;
    }

    @Override
    public void setTask(Task newTask) {
        p.setTask(newTask);
    }
}
