import junit.framework.TestSuite;
import junit.framework.Test;
import junit.textui.TestRunner;

public class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(AdelJUnitTest.class);
        suite.addTestSuite(EinwohnerJUnitTest.class);
        suite.addTestSuite(KoenigJUnitTest.class);
        suite.addTestSuite(LeibeigenerJUnitTest.class);
        return suite;
    }
    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
