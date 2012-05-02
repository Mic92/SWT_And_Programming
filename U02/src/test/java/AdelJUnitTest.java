import junit.framework.TestCase;

public class AdelJUnitTest extends TestCase {
    Adel a1 = new Adel();
    public void testAdel() {
        a1.setEinkommen(1);
        assertEquals(20,a1.steuer());
        a1.setEinkommen(2000);
        assertEquals(200,a1.steuer());
    }
}
