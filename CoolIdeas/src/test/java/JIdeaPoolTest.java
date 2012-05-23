/**
 *
 * @author Max Leuthäuser
 */
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

public class JIdeaPoolTest {

	JIdeaPool ideaPool = new JIdeaPool();
	Map<JTopic, Set<JIdea>> expPool = new HashMap<JTopic, Set<JIdea>>();
	JTopic t1 = new JTopic(1, "titelTopic1", "descriptionTopic1");
	JTopic t2 = new JTopic(2, "titelTopic2", "descriptionTopic2");
	JTopic t3 = new JTopic(3, "titelTopic3", "descriptionTopic3");
	JIdea i1 = new JIdea("titelIdea1", "descriptionIdea1");
	JIdea i2 = new JIdea("titelIdea2", "descriptionIdea2");
	JIdea i3 = new JIdea("titelIdea3", "descriptionIdea3");
	Set<JIdea> expSet = new HashSet<JIdea>();

	/**
	 * Test of add method, of class JIdeaPool.
	 */
	@Test
	public void testAddJTopicWithNoIdeas() {
		ideaPool.add(t1);
		expPool.put(t1, new HashSet<JIdea>());
		try {
			@SuppressWarnings("unchecked")
			HashMap<JTopic, Set<JIdea>> actPool = (HashMap<JTopic, Set<JIdea>>) getPool();
			assertEquals(
					"Your method 'add(JTopic topic)' in the class JIdeaPool"
							+ " did not work correctly. There should be added a new"
							+ " Set of ideas if the pool does not contains the given topic.",
					expPool.get(t1).isEmpty(), actPool.get(t1).isEmpty());
			ideaPool.add(i1, t1);
			ideaPool.add(t1);
			assertTrue("Your method 'add(JTopic topic)' in the class JIdeaPool"
					+ " did not work correctly. A topic should not be added if"
					+ " it exists allready.", actPool.get(t1).contains(i1));
		} catch (ClassCastException e) {
			fail("The type of the attribute 'pool' in the class JIdeaPool should be 'Map<JTopic, Set<JIdea>>'.");
		}
	}

	/**
	 * Test of add method, of class JIdeaPool.
	 */
	@Test
	public void testAddJTopicWithIdeas() {
		ideaPool.add(i1, t1);
		expSet.add(i1);
		expPool.put(t1, expSet);
		try {
			@SuppressWarnings("unchecked")
			HashMap<JTopic, Set<JIdea>> actPool = (HashMap<JTopic, Set<JIdea>>) getPool();
			assertEquals(
					"Your method 'add(JIdea idea, JTopic topic)' in the class JIdeaPool"
							+ " did not work correctly. There should be added a new"
							+ " Set with the given idea if the pool does not contains the given topic.",
					expPool.get(t1), actPool.get(t1));
			ideaPool.add(i2, t1);
			assertEquals(
					"Your method 'add(JIdea idea, JTopic topic)' in the class JIdeaPool"
							+ " did not work correctly. If the topic exists allready the given idea"
							+ " should be added to the set.", 2, actPool
							.get(t1).size());
		} catch (ClassCastException e) {
			fail("The type of the attribute 'pool' in the class JIdeaPool should be 'Map<JTopic, Set<JIdea>>'.");
		}
	}

	/**
	 * Test of remove method, of class JIdeaPool.
	 */
	@Test
	public void testRemoveJIdea() {
		ideaPool.add(i1, t1);
		ideaPool.add(i3, t2);
		assertTrue(
				"The method 'remove(JIdea idea)' should return true if the given"
						+ " idea exists in the pool and was removed succesfull.",
				ideaPool.remove(i1));
		assertTrue(
				"The method 'remove(JIdea idea)' should return true if the given"
						+ " idea exists in the pool and was removed succesfull.",
				ideaPool.remove(i3));
		assertFalse(
				"The method 'remove(JIdea idea)' should return false if the given"
						+ " idea dont exists in the pool.", ideaPool.remove(i2));
	}

	/**
	 * Test of remove method, of class JIdeaPool.
	 */
	@Test
	public void testRemoveJTopic() {
		ideaPool.add(t1);
		ideaPool.add(t3);
		assertTrue(
				"The method 'remove(JTopic topic)' should return true if the given"
						+ " topic exists in the pool and was removed succesfull.",
				ideaPool.remove(t1));
		assertTrue(
				"The method 'remove(JTopic topic)' should return true if the given"
						+ " topic exists in the pool and was removed succesfull.",
				ideaPool.remove(t3));
		assertFalse(
				"The method 'remove(JTopic topic)' should return false if the given"
						+ " topic dont exists in the pool.",
				ideaPool.remove(t2));
	}

	/**
	 * Test of numberOfTopics method, of class JIdeaPool.
	 */
	@Test
	public void testNumberOfTopics() {
		ideaPool.add(t1);
		ideaPool.add(t3);
		assertEquals(
				"The method 'numberOfTopics()' did not work correctly."
						+ " It should return the current number of topics in the pool.",
				2, ideaPool.numberOfTopics());
	}

	/**
	 * Test of numberOfIdeas method, of class JIdeaPool.
	 */
	@Test
	public void testNumberOfIdeas() {
		ideaPool.add(i1, t1);
		ideaPool.add(i2, t1);
		ideaPool.add(i2, t2);
		ideaPool.add(i3, t2);
		assertEquals(
				"The method 'numberOfIdeas()' did not work correctly."
						+ " It should return the current number of ideas in the pool."
						+ " Mind the special case of identical ideas in different topics!",
				3, ideaPool.numberOfIdeas());
	}

	/**
	 * Return the Content of the Attribute "pool"
	 */
	public Object getPool() {
		Class<?> c = ideaPool.getClass();

		// Get attribute pool, set the mode to accessible and return the content
		try {
			Field myField = c.getDeclaredField("pool");
			myField.setAccessible(true);
			return myField.get(ideaPool);
		} catch (NoSuchFieldException e) {
			throw new AssertionError(
					"The class 'JIdeaPool' must have an attribute 'pool'");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("AssertionError while accessing JIdeaPool");
		}
	}
}
