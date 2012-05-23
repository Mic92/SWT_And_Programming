
/**
 *
 * @author Max Leuthäuser
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateOpenDraftTest extends BasicTest {

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
        i.hold();
        assertEquals("An open draft should become an approved idea if the community decided"
                + " to hold it.", i.new ApprovedIdea().getClass(), super.getState().getClass());
    }

    @Test
    public void testDecline() {
        i.hold();
        i.decline();
        assertEquals("An open draft should be removed from the system if it is declined."
                + " So simply do not change the state.", i.new OpenDraft().getClass(), super.getState().getClass());
    }

    @Test
    public void testDiscuss() {
        i.hold();
        i.discuss("discussion");
        assertEquals("You should not change the state of an open draft"
                + " while it is discussed.", i.new OpenDraft().getClass(), super.getState().getClass());
        assertEquals("If an idea is discussed each new discussion text"
                + " should be added to the old one with a line break"
                + " at the end.", "discussion\n", i.getCurrentDiscussion());
    }

    @Test
    public void testEvaluate() {
        JValuation v = new JValuation("titel", "description");
        i.hold();
        i.evaluate(v);
        assertEquals("You should not change the state of an open draft"
                + " while it is evaluated.", i.new OpenDraft().getClass(), super.getState().getClass());
        assertEquals("If an idea is evaluated the current valuation"
                + " should be replaced with the new one.", v, i.getValuation());
    }
}
