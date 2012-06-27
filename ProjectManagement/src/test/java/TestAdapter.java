import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.*;
/**
 *  ProjectManagement Test for the Adapter
 *  
 * Created on: 
 *   14.02.2008
 *   20:45
 * 
 * @author koschka
*/

public class TestAdapter extends TestCase {
	private Client c;
	private List<Deliverable> solution;
	
	public void setUp()
	{
		Task t1, t2;
		Deliverable d1, d2, d3, d4;
		Calendar cal, cal2, cal3, cal4;
		
		List<Deliverable> list = new ArrayList<Deliverable>();
		cal = new GregorianCalendar();
		cal2 = new GregorianCalendar();
		cal3 = new GregorianCalendar();
		cal4 = new GregorianCalendar();
		cal.set(2008, 2, 10);
		
		d1 = new Deliverable("checkTask", 
							"Auftragsliste anfordern",
							10, 30, 1, cal);
		list.add(d1);
		
		cal2.set(2008, 2, 20);
		d2 = new Deliverable("checkAvailability", 
							"Verfügbarkeit der Ware checken",
							0, 100, 1, cal2);
		list.clear();
		list.add(d2);

		cal3.set(2008, 3, 2);
		d3 = new Deliverable("checkAccount", 
							"Kundenkonto prüfen",
							30, 30, 1, cal3);
		list.clear();
		list.add(d3);
		
		cal4.set(2008, 3, 23);
		d4 = new Deliverable("confirmOrder", 
				"Ware ausliefern",
				1000, 100, 2, cal4);
		
		list.clear();
		list.add(d4);
		
		t2 = new Task("confirmTask", "Auftrag pr�fen", 1);
		t2.addProjectItem(d2);
		t2.addProjectItem(d3);
		
		t1 = new Task("shipOrdering", "Ware verschicken", 1);
		t1.addProjectItem(d1);
		t1.addProjectItem(t2);
		t1.addProjectItem(d4);
		
		c = new Client();
		c.init(t1);
		
		solution = new ArrayList<Deliverable>();
		solution.add(d1);
		solution.add(d2);
		solution.add(d3);
		solution.add(d4);
	}
	
	public void testDurationAndTotalCosts()
	{
		assertEquals("The getDuration method doesn't return the correct required time for the actual Task", 
						260.0, c.ProjectAdapter.getDuration());
		assertEquals("The getTotalCosts method doesn't return the correct costs for the actual Task", 
						1300.0, c.ProjectAdapter.getTotalCost());		
	}
	
	public void testAllDeliverables() throws AssertionError
	{
		List<Deliverable> userSolution = c.ProjectAdapter.getDeliverables();
		if(userSolution.size() != solution.size())
			throw new AssertionError("The TestProject has four different Deliverables, your Adapter only returns " + userSolution.size());
		
		if(!userSolution.containsAll(solution))
			throw new AssertionError("Your Solution does not contain all Deliverables! expected:" + solution + "; yours: " + userSolution);		
	}
}
