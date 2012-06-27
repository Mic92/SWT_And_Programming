import java.util.Calendar;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import junit.framework.*;

/**
 *  ProjectManagement Test for Task, Deliverable and ProjectItem
 *  
 * Created on: 
 *   14.02.2008
 *   20:00
 * 
 * @author koschka
*/

public class TestComposite extends TestCase {
	private Task t1;
	private Deliverable d1, d2;
	private Calendar cal;
	
	public void setUp() throws Exception
	{
		cal = new GregorianCalendar();
		cal.set(1999, 11, 23);
		t1 = new Task("name", "test", 20);
		d1 = new Deliverable("d1", "Some Paper", 10, 2, 2, cal);
		d2 = new Deliverable("d1", "Some Paper2", 10, 2, 2, cal);
	}
	
	public void testEmptyTaskClass()
	{
		assertTrue("A Task has no deliverables currently after creating", 
					t1.allDeliverables().isEmpty());
		assertTrue("A Task has no costs if there are no deliverables", 
					t1.getMaterialsCost() == 0);
		assertTrue("A Task has no time requirement if there are no deliverables", 
					t1.getTimeRequired() == 0);
	}
	
	public void testEmptyDeliverableClass()
	{
		assertTrue("A Deliverable has to have required Time * rate + costs as Cost Estimate!", 
					d1.getCostEstimate() == 14);
	}
	
	public void testFilledTaskClass()
	{
		t1.addProjectItem(d1);
		t1.addProjectItem(d2);
		
		Set<Deliverable> result = new HashSet<Deliverable>();
		result.add(d1);
		result.add(d2);
		
		assertTrue("A ProjectItem has to be added by the addProjectItem method", 
					t1.allDeliverables().size() == 2);
		assertTrue("The method addDeliverables has to return all deliverables", 
					result.containsAll(t1.allDeliverables()));
		
		t1.addProjectItem(d1);
		
		assertTrue("A ProjectItem has to be added by the addProjectItem method only if it isn't in a task yet", 
					t1.allDeliverables().size() == 2);
		
		result.remove(d1);
		t1.removeProjectItem(d1);
		
		assertTrue("The method removeProjectItem has to remove a projectItem", 
					result.containsAll(t1.allDeliverables()));
	}
}
