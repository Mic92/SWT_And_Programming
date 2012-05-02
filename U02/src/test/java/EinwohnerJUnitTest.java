import junit.framework.TestCase;

public class EinwohnerJUnitTest extends TestCase {
    Einwohner e1 = new Einwohner();

    public void testSteuer() {
        e1.setEinkommen(-10);
        assertEquals(1,e1.steuer());
        e1.setEinkommen(1);
        assertEquals(1,e1.steuer());
        e1.setEinkommen(20);
        assertEquals(2,e1.steuer());
    }
}