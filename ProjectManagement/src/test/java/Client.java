import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * A Client which knows the IProject Interface
 *
 */
public class Client {
	IProject ProjectAdapter;

	/**
	 * Constructor
	 */
	public Client()
	{
		ProjectAdapter = new Adapter("Test", "Only a for Tests", 100);
	}
	
	/**
	 * Initializes a Client with some Data
	 */
	public void init()
	{
		Task t = new Task(	"Projekt erstellen",
				"Welche Aufgaben muss ich bei einer Projekterstellung beachten?",
				40);
		Task t2= new Task(	"Team zusammenstellen",
			"Welche Aufgabe bekommt ein Teammitglied?",
			40);
		
		Calendar cal = new GregorianCalendar();
		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.set(1990, 11, 23);
		
		
		t.addProjectItem(new Deliverable("lesen", "Aufgabenstellung lesen", 
									0, 10, 10, cal));
		
		t2.addProjectItem(new Deliverable("tester", "Tester aussuchen", 
						0, 5, 10, cal));
		t.addProjectItem(new Deliverable("tester", "Tester aussuchen", 
			0, 5, 10, cal2));
		t.addProjectItem(t2);
		
		ProjectAdapter.setTask(t);
	}
	
	/**
	 * Initializes a Client with a specified Task
	 * 
	 * @param Task A Task to be set
	 */
	public void init(Task task)
	{
		ProjectAdapter.setTask(task);
	}
	
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		Client c = new Client();
		c.init();
		
		c.print();
	}
	
	/**
	 * Print Current Deliverables
	 */
	public void print()
	{
		System.out.println(	ProjectAdapter.getDeliverables());	
	}
}
