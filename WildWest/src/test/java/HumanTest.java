package praktomat.WildWest;
import java.lang.reflect.Modifier;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Max Leuthäuser
 */
public class HumanTest extends TestCase {

    HumanImpl h = new HumanImpl();

	/**
	 * Test if Human is abstract.
	 */
	@Test
	public void testInstantiateHuman() {
		assertTrue("Human should be abstract!", Modifier.isAbstract(Human.class.getModifiers()));
	}

    /**
     * Test of getName method, of class Human.
     */
    @Test
    public void testGetName() {
        assertEquals("The method getName() of class Human did not work correctly.", "Name", h.getName());
    }

    /**
     * Test of getAge method, of class Human.
     */
    @Test
    public void testGetAge() {
        assertEquals("The method getAge() of class Human did not work correctly.", 20, h.getAge());
    }

    /**
     * Test of getHorseName method, of class Human.
     */
    @Test
    public void testGetHorseName() {
        assertEquals("The method getHorseName() of class Human did not work correctly.", "Pferd", h.getHorseName());
    }

    /**
     * Test of getFightExperience method, of class Human.
     */
    @Test
    public void testGetFightExperience() {
        assertEquals("The method getFightExperience() of class Human did not work correctly.", FightExperience.EXPERIENCED, h.getFightExperience());
    }

    /**
     * Test of getDrunkenness method, of class Human.
     */
    @Test
    public void testGetDrunkenness() {
        assertEquals("The method getDrunkenness() of class Human did not work correctly.", Drunkenness.SMILEY, h.getDrunkenness());
    }

    /**
     * Test of drinkSomeWhisky method, of class Human.
     */
    @Test
    public void testDrinkSomeWhisky() {
         assertEquals("The method getDrunkenness() of class Human did not work correctly.", Drunkenness.SMILEY, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.FRIENDLY, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.CHATTY, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.CONTROLLEDBUZZ, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.BUZZED, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.DRUNK, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.HAMMERED, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.BOMBED, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.SHITFACED, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.BLACKOUT, h.getDrunkenness());

         h.drinkSomeWhisky();
         assertEquals("The method DrinkSomeWhisky() of class Human did not work correctly.", Drunkenness.BLACKOUT, h.getDrunkenness());
    }

    public class HumanImpl extends Human {

        public HumanImpl() {
            super("Name", 20, "Pferd", FightExperience.EXPERIENCED);
        }
    }
}
