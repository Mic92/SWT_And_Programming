import java.util.*; // gilt für alle Klassen
public class Project {
    private Task task;

    public Project(String name, String description, double rate) {
        task = new Task(name,description,rate);
    }

    public String getName() {
        return task.getName();
    }
    /**
     * Diese Operation liefert alle Deliverables des Projekts indiziert
     * nach dem Datum (Calendar), zu dem sie fällig sind. */
    public Map<Calendar, List<Deliverable>> allDeliverables() {
        Set<Deliverable> s = task.allDeliverables();
        Map<Calendar,List<Deliverable>> m = new HashMap<Calendar, List<Deliverable>>();
        for(Deliverable d: s) {
            Calendar c = d.getDate();
            List<Deliverable> l = m.get(c);
            if (l == null) {
                l = new ArrayList<Deliverable>();
                m.put(c,l);
            }
            l.add(d);
        }
        return m;
    }
    public double getDuration() { // Gesamtdauer des Projektes
        return task.getTimeRequired();
    }
    public double getTotalCost() { // Gesamtkosten des Projektes
        return task.getCostEstimate();
    }
    public void setTask(Task newTask) {
        this.task = newTask;
    }
}