import static org.junit.Assert.*;

import java.util.Observable;

import org.junit.Before;
import org.junit.Test;

/**
 * Test to check the implementation of the observer pattern.
 * 
 * @author Max Leuthäuser
 */
public class OberverTest {
	private JMember m1, m2;
	private JTopic t1, t2;
	private JContentImpl c1;

	/**
	 * We set up all necessary objects to test them later.
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m1 = new JMember();
		m2 = new JMember();
		t1 = new JTopic(1, "titel1", "description1");
		t2 = new JTopic(2, "titel2", "description2");
		c1 = new JContentImpl("titelC", "descriptionC");
	}

	@Test
	public void testStructure() {
		assertTrue("JContent should extend java.util.Observable!",
				c1 instanceof Observable);
		boolean memberImplementsObserver = false;
		for (Class<?> i : m1.getClass().getInterfaces()) {
			if (i.getName().equals(java.util.Observer.class.getName())) {
				memberImplementsObserver = true;
				break;
			}
		}
		assertTrue("JMember should implement java.util.Observer!",
				memberImplementsObserver);
	}

	@Test
	public void testNotification() {
		m1.subscribeToTopic(t1);
		m2.subscribeToTopic(t2);

		assertEquals(
				"The JMember should be subscribed to the topic set with 'subscribeToTopic(JTopic topic).'",
				m1.getSubscribedTopic(), t1);
		assertEquals(
				"The JMember should be subscribed to the topic set with 'subscribeToTopic(JTopic topic).'",
				m2.getSubscribedTopic(), t2);

		t1.setTitel("newTitel1");
		t1.setDescription("newDescription1");

		t2.setTitel("newTitel2");
		t2.setDescription("newDescription2");

		assertTrue(
				"If a topic is changed all members that are subscribed to it should get informed and updated.",
				m1.getSubscribedTopic().getTitel().equals(t1.getTitel()));
		assertTrue(
				"If a topic is changed all members that are subscribed to it should get informed and updated.",
				m1.getSubscribedTopic().getDescription().equals(
						t1.getDescription()));
		assertTrue(
				"If a topic is changed all members that are subscribed to it should get informed and updated.",
				m2.getSubscribedTopic().getTitel().equals(t2.getTitel()));
		assertTrue(
				"If a topic is changed all members that are subscribed to it should get informed and updated.",
				m2.getSubscribedTopic().getDescription().equals(
						t2.getDescription()));

		assertFalse(
				"A member must not get informed if a topic changes he is not subscribed to.",
				m1.getSubscribedTopic().getTitel().equals(t2.getTitel()));
		assertFalse(
				"A member must not get informed if a topic changes he is not subscribed to.",
				m1.getSubscribedTopic().getDescription().equals(
						t2.getDescription()));
	}

	private class JContentImpl extends JContent {
		public JContentImpl(String titel, String description) {
			super(titel, description);
		}
	}
}
