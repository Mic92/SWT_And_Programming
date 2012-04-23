package praktomat.WildWest;
import org.junit.Test;
import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 *
 * @author Max Leuthäuser
 */
public class SaloonTest extends TestCase {
    Saloon s = new Saloon("Name", "Location");
    /**
     * Test of getName method, of class Saloon.
     */
    @Test
    public void testGetName() {
        assertEquals("The method getName() of class Saloon did not work correctly.", "Name", s.getName());
    }

    /**
     * Test of getLocation method, of class Saloon.
     */
    @Test
    public void testGetLocation() {
        assertEquals("The method getName() of class Saloon did not work correctly.", "Location", s.getLocation());
    }

}