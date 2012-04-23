
import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.HashSet;

/**
 *
 * @author Max Leuthäuser
 */
public class WesternTownTest extends TestCase {
    private Villain v1 = new Villain("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Villain v2 = new Villain("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Villain v3 = new Villain("Name3", 23, "Pferd3", FightExperience.HIGH);
    private Villain v4 = new Villain("Name4", 24, "Pferd4", FightExperience.GODLIKE);
    private Sheriff s1 = new Sheriff("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Sheriff s2 = new Sheriff("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Sheriff s3 = new Sheriff("Name3", 23, "Pferd3", FightExperience.HIGH);
    private Sheriff s4 = new Sheriff("Name4", 24, "Pferd4", FightExperience.GODLIKE);

    Saloon sl = new Saloon("name", "location");
    private WesternTown w = new WesternTown("location", 1850, sl);

    /**
     * Test of getTime method, of class WesternTown.
     */
    @Test
    public void testGetTime() {
        assertEquals("Your getTime() from WesternTown did not work correctly.", 1850, w.getTime());
    }

    /**
     * Test of getLocation method, of class WesternTown.
     */
    @Test
    public void testGetLocation() {
        assertEquals("Your getLocation() from WesternTown did not work correctly.", "location", w.getLocation());
    }

    /**
     * Test of getVillains method, of class WesternTown.
     */
    @Test
    public void testGetVillains() {
        w.addVillain(v1);
        w.addVillain(v2);
        w.addVillain(v3);

        LinkedList<Villain> l = new LinkedList<Villain>();
        l.add(v1);
        l.add(v2);
        l.add(v3);

        assertEquals("Your getVillains() from WesternTown did not work correctly.", l, w.getVillains());
    }

    /**
     * Test of getSheriffs method, of class WesternTown.
     */
    @Test
    public void testGetSheriffs() {
        w.addSheriff(s1);
        w.addSheriff(s2);
        w.addSheriff(s3);

        LinkedList<Sheriff> s = new LinkedList<Sheriff>();
        s.add(s1);
        s.add(s2);
        s.add(s3);

        assertEquals("Your getSheriffs() from WesternTown did not work correctly.", s, w.getSheriffs());
    }
    /**
     * Test of getSaloon method, of class WesternTown.
     */
    @Test
    public void testGetSaloon() {
        assertEquals("Your getSaloon() from WesternTown did not work correctly.", sl , w.getSaloon());
    }

    /**
     * Test of getRandomSheriff method, of class WesternTown.
     */
    @Test
    public void testGetRandomSheriff() {
        w.addSheriff(s1);
        w.addSheriff(s2);
        w.addSheriff(s3);
        w.addSheriff(s4);
        HashSet<Sheriff> storeRndSheriffs = new HashSet<Sheriff>();

        for (int i=0; i<20; i++) {
            storeRndSheriffs.add(w.getRandomSheriff());
        }

        assertTrue("Your getRandomSheriffs() from WesternTown should deliver one Sheriff randomized.", storeRndSheriffs.size() > 1);
    }

    /**
     * Test of getRandomVillain method, of class WesternTown.
     */
    @Test
    public void testGetRandomVillain() {
        w.addVillain(v1);
        w.addVillain(v2);
        w.addVillain(v3);
        w.addVillain(v4);
        HashSet<Villain> storeRndVillains = new HashSet<Villain>();

        for (int i=0; i<20; i++) {
            storeRndVillains.add(w.getRandomVillain());
        }

        assertTrue("Your getRandomVillain() from WesternTown should deliver one Villain randomized.", storeRndVillains.size() > 1);
    }

    /**
     * Test of addSheriff method, of class WesternTown.
     */
    @Test
    public void testAddSheriff() throws Exception {
        Saloon saloon = new Saloon("name", "location");
        WesternTown wt = new WesternTown("location", 1850, saloon);
        try {
            wt.addSheriff(null);
            fail("A NullPointerException should be thrown!");
	} catch(NullPointerException exception) {
        }
        Sheriff s = new Sheriff("Name1", 21, "Pferd1", FightExperience.LOWBOB);
        wt.addSheriff(s);
        assertTrue("Your addSheriff() from WesternTown did not work correctly.", wt.getSheriffs().contains(s));
        assertFalse("It should not be possible to add the same Sheriff twice.", wt.addSheriff(s));
    }

    /**
     * Test of addVillain method, of class WesternTown.
     */
    @Test
    public void testAddVillain() {
        Saloon saloon = new Saloon("name", "location");
        WesternTown wt = new WesternTown("location", 1850, saloon);
        try {
            wt.addVillain(null);
            fail("A NullPointerException should be thrown!");
	} catch(NullPointerException exception) {
        }    
        Villain v = new Villain("Name1", 21, "Pferd1", FightExperience.LOWBOB);
        wt.addVillain(v);
        assertTrue("Your addVillain() from WesternTown did not work correctly.", wt.getVillains().contains(v));
        assertFalse("It should not be possible to add the same Villain twice.", wt.addVillain(v));
    }
}
