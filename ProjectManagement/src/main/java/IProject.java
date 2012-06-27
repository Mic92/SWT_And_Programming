import java.util.List;
public interface IProject {
    public double getDuration();
    public double getTotalCost();
    public List<Deliverable> getDeliverables();
    public void setTask(Task newTask);
}
