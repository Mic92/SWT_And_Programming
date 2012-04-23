import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Max Leuthäuser
 */
public class SheriffTest extends TestCase {
    private Villain v1 = new Villain("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Villain v2 = new Villain("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Villain v4 = new Villain("Name4", 24, "Pferd4", FightExperience.GODLIKE);
    private Sheriff s1 = new Sheriff("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Sheriff s2 = new Sheriff("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Sheriff s3 = new Sheriff("Name3", 23, "Pferd3", FightExperience.HIGH);
    private Sheriff s4 = new Sheriff("Name4", 24, "Pferd4", FightExperience.GODLIKE);

    /**
     * Test of fightAgainstVillain method, of class Sheriff.
     */
    @Test
    public void testFightAgainstVillain() {
        // Test same levels
        assertFalse("Check your FightAgainstVillain() if villain and sherriff are at the same levels.", s1.fightAgainstVillain(v1));
        assertEquals("If villain and sherriff are at the same level the sherriff should not loose.", 0, s1.getLosses());
        assertEquals("If villain and sherriff are at the same level the sherriff should not win.", 0, s1.getVictories());

        // Test same Drunkenness but Sheriff has higher FightExp
        assertTrue("Sheriff should win if Drunkeness is the same but FightExp is higher.", s3.fightAgainstVillain(v2));
        assertEquals("If they have the same Drunkenness but Sheriff has higher FightExp he should win.", 1, s3.getVictories());

        // Test same Drunkenness but Sheriff has lower FightExp
        assertFalse("Sheriff should loose if Drunkeness is the same but FightExp is lower.", s2.fightAgainstVillain(v4));
        assertEquals("If they have the same Drunkenness but Sheriff has lower FightExp he should loose.", 1, s2.getLosses());

        // Test same FightExp but Sheriff is less drunk
        v2.drinkSomeWhisky();
        assertTrue("Sheriff should win if FightExp is the same but Drunkenness is lower.", s2.fightAgainstVillain(v2));
        assertEquals("If they have the same FightExp but Sheriff is less drunk he should win.", 1, s2.getVictories());

        // Test same FightExp but Sheriff is more drunk
        s4.drinkSomeWhisky();
        assertFalse("Sheriff should loose if FightExp is the same but Drunkenness is higher.", s4.fightAgainstVillain(v4));
        assertEquals("If they have the same FightExp but Sheriff is more drunk he should loose.", 1, s4.getLosses());
    }

    /**
     * Test of getVictories method, of class Sheriff.
     */
    @Test
    public void testGetVictories() {
        assertEquals("getVictories() of class Sheriff should return 0 at beginning", 0, s1.getVictories());
    }

    /**
     * Test of getLosses method, of class Sheriff.
     */
    @Test
    public void testGetLosses() {
        assertEquals("getLosses() of class Sheriff should return 0 at beginning", 0, s1.getLosses());
    }

}
