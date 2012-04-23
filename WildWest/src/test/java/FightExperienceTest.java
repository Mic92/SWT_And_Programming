package praktomat.WildWest;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

/**
 *
 * @author Max Leuthäuser
 */
public class FightExperienceTest extends TestCase {
    FightExperience d;
    ExpFightExperience e;

    public enum ExpFightExperience {
        LOWBOB,
        EXPERIENCED,
        HIGH,
        GODLIKE,
    }

    /**
     * Test of values method, of class FightExperience.
     */
    @Test
    public void testValues() {
        assertEquals("The Enum FightExperience is not set up correctly.", d, e);
    }

}