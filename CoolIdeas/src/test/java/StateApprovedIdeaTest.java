
/**
 *
 * @author Max Leuthäuser
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateApprovedIdeaTest extends BasicTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testRelease() {
        i.hold();
        i.hold();
        i.hold();
        assertEquals("An approved idea should be removed from the system if it is released. + "
                + " So simply do not change the state.", i.new ApprovedIdea().getClass(), super.getState().getClass());
    }
}
