
/**
 *
 * @author Max Leuthäuser
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateDraftTest extends BasicTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testHold() {
        i.hold();
        assertEquals("A draft should become an open draft if the community decided"
                + " to hold it.", i.new OpenDraft().getClass(), super.getState().getClass());
    }

    @Test
    public void testDecline() {
        i.decline();
        assertEquals("A draft should be removed from the system if it is declined. + "
                + " So simply do not change the state.", i.new Draft().getClass(), super.getState().getClass());
    }
}
