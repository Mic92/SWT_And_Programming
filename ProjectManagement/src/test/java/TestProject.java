import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.GregorianCalendar;

import junit.framework.*;

/**
 *  ProjectManagement Test for the Project Class
 *  
 * Created on: 
 *   14.02.2008
 *   20:15
 * 
 * @author koschka
*/

public class TestProject extends TestCase {
	private Project p1;
	private Task t1, t2;
	private Deliverable d1, d2, d3, d4;
	private Calendar cal, cal2, cal3, cal4;
	private Map<Calendar, List<Deliverable>> solution;
	List<Deliverable> list = new ArrayList<Deliverable>();
	
	public void setUp()
	{
		solution = new HashMap<Calendar, List<Deliverable>>();
		cal = new GregorianCalendar();
		cal2 = new GregorianCalendar();
		cal3 = new GregorianCalendar();
		cal4 = new GregorianCalendar();
		cal.set(2008, 2, 10);
		
		d1 = new Deliverable("checkTask", 
							"Auftragsliste anfordern",
							10, 30, 1, cal);
		list.add(d1);
		solution.put(cal, list);		
		
		cal2.set(2008, 2, 20);
		d2 = new Deliverable("checkAvailability", 
							"Verfügbarkeit der Ware checken",
							0, 100, 1, cal2);
		list = new ArrayList<Deliverable>();
		list.add(d2);
		solution.put(cal2, list);

		
		cal3.set(2008, 3, 2);
		d3 = new Deliverable("checkAccount", 
							"Kundenkonto prüfen",
							30, 30, 1, cal3);
		list = new ArrayList<Deliverable>();
		list.add(d3);
		solution.put(cal3, list);
		
		cal4.set(2008, 3, 23);
		d4 = new Deliverable("confirmOrder", 
				"Ware ausliefern",
				1000, 100, 2, cal4);
		
		list = new ArrayList<Deliverable>();
		list.add(d4);
		solution.put(cal4, list);
		
		t2 = new Task("confirmTask", "Auftrag pr�fen", 1);
		t2.addProjectItem(d2);
		t2.addProjectItem(d3);
		
		t1 = new Task("shipOrdering", "Ware verschicken", 1);
		t1.addProjectItem(d1);
		t1.addProjectItem(t2);
		t1.addProjectItem(d4);
		
		p1 = new Project("shipOrdering", "Ware verschicken", 1);
		p1.setTask(t1);
	}
	
	public void testProjectCostsAndDuration()
	{	
		assertEquals("The getDuration method doesn't return the correct required time for the actual Task",
						260.0, p1.getDuration());
		assertEquals("The getTotalCosts method doesn't return the correct costs for the actual Task", 
						1300.0, p1.getTotalCost());
	}
	
	public void testAllDeliverables()
	{
		// There are 4 Deliverables...
		assertEquals("The allDeliverables Method doesn't return all Deliverables", 
						4, p1.allDeliverables().size());
		
		// check if there are all Dates
		if(!(p1.allDeliverables().keySet().size() == solution.keySet().size()))
			throw new AssertionError("The Mapping has to have 4 different dates, you only have " + p1.allDeliverables().keySet().size());
		
		// check if you have the correct values in the mapping
		if(!solution.values().containsAll(p1.allDeliverables().values()))
			throw new AssertionError("Invalid values in the mapping: expected:" + solution.values() + " yours :" + p1.allDeliverables().values());
	}
}
