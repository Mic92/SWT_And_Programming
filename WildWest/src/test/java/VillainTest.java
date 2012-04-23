import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Max Leuthäuser
 */
public class VillainTest extends TestCase {
    private Villain v1 = new Villain("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Villain v2 = new Villain("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Villain v3 = new Villain("Name3", 23, "Pferd3", FightExperience.HIGH);
    private Villain v4 = new Villain("Name4", 24, "Pferd4", FightExperience.GODLIKE);
    private Sheriff s1 = new Sheriff("Name1", 21, "Pferd1", FightExperience.LOWBOB);
    private Sheriff s2 = new Sheriff("Name2", 22, "Pferd2", FightExperience.EXPERIENCED);
    private Sheriff s4 = new Sheriff("Name4", 24, "Pferd4", FightExperience.GODLIKE);

    /**
     * Test of fightAgainstSheriff method, of class Villain.
     */
    @Test
    public void testFightAgainstSheriff() {
        // Test same levels
        assertFalse("Check your fightAgainstSheriff() if villain and sheriff are at the same levels.", v1.fightAgainstSheriff(s1));

        // Test same Drunkenness but Villain has higher FightExp
        assertTrue("Villain should win if Drunkeness is the same but FightExp is higher.", v3.fightAgainstSheriff(s2));

        // Test same Drunkenness but Villain has lower FightExp
        assertFalse("Villain should loose if Drunkeness is the same but FightExp is lower.", v2.fightAgainstSheriff(s4));

        // Test same FightExp but Villain is less drunk
        s2.drinkSomeWhisky();
        assertTrue("Villain should win if FightExp is the same but Drunkenness is lower.", v2.fightAgainstSheriff(s2));

        // Test same FightExp but Villain is more drunk
        v4.drinkSomeWhisky();
        assertFalse("Villain should loose if FightExp is the same but Drunkenness is higher.", v4.fightAgainstSheriff(s4));       
    }
}
