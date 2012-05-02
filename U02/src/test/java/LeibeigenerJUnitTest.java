import junit.framework.TestCase;

public class LeibeigenerJUnitTest extends TestCase {
    Leibeigener b = new Leibeigener();
    public void testLeibeigener() {
        b.setEinkommen(20);
        assertEquals(1,b.steuer());
        b.setEinkommen(10);
        assertEquals(1,b.steuer());
    }
}
