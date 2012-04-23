import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Max Leuthäuser
 */
public class DrunkennessTest extends TestCase {

    Drunkenness d;
    ExpDrunkenness e;
    
    public enum ExpDrunkenness {
        SMILEY,
        FRIENDLY,
        CHATTY,
        CONTROLLEDBUZZ,
        BUZZED,
        DRUNK,
        HAMMERED,
        BOMBED,
        SHITFACED,
        BLACKOUT
    }

    /**
     * Test of values method, of class Drunkenness.
     */
    @Test
    public void testValues() {
        assertEquals("The enum Drunkenness is not set up correctly.", d, e);
    }

}
