import junit.framework.TestCase;

public class KoenigJUnitTest extends TestCase  {
    Koenig e1 = new Koenig();
    public void testSteuer() {
        e1.setEinkommen(10);
        assertEquals(0,e1.steuer());
        e1.setEinkommen(-10);
        assertEquals(0,e1.steuer());
    }
}
