
/**
 *
 * @author Max Leuthäuser
 */
import java.io.File;
import java.util.List;
import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class JIdeaTest {

    JIdea i = new JIdea("titel", "description");
    JAttachment a = new JAttachment("titelA", "descriptionA", new File("/dev/null"));
    JAttachment b = new JAttachment("titelB", "descriptionB", new File("/dev/null"));
    JAttachment c = new JAttachment("titelC", "descriptionC", new File("/dev/null"));
    List<JAttachment> expAttachments = new LinkedList<JAttachment>();

    /**
     * Test of getAttechments method, of class JIdea.
     */
    @Test
    public void testGetAttechments() {
        expAttachments.add(a);
        expAttachments.add(b);
        expAttachments.add(c);

        i.addAttachment(a);
        i.addAttachment(b);
        i.addAttachment(c);

        Boolean b = true;
        int z = 0;
        List<JAttachment> actAttachments = i.getAttachments();

        for (JAttachment rA : expAttachments) {
            b = rA.toString().equals(actAttachments.get(z).toString());
            z++;
        }

        assertTrue("The method 'getAttachments' of the class JIdea"
                + "did not work correctly. If you find nothing there"
                + "you may check 'addAttachments' too.", b);
    }

    /**
     * Test of removeAttechment method, of class JIdea.
     */
    @Test
    public void testRemoveAttechment() {
        i.removeAttachment(a);
        expAttachments.remove(a);

        Boolean b = true;
        int z = 0;
        List<JAttachment> actAttachments = i.getAttachments();

        for (JAttachment rA : expAttachments) {
            b = rA.toString().equals(actAttachments.get(z));
            z++;
        }

        assertTrue("The method 'removeAttachments' of the class JIdea"
                + "did not work correctly.", b);

    }

    /**
     * Test of toString method, of class JIdea.
     */
    @Test
    public void testToString() {
        String expResult = "Idea: " + "titel" + "\n"
                + "description";
        assertEquals("The method 'toString' of the class JIdea"
                + "did not work correctly.", expResult, i.toString());
    }
}
