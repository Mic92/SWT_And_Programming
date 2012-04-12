import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Max Leuthaeuser
 */
public class CheckIfPrimeTest {

    private final int[] testNumbersNoPrimes = {0, 1, 10, 78900, 10098, 1068, 10000001};
    private final int[] testNumbersPrimes = {2, 10007, 99083, 99089, 10093, 99109, 99119, 99131, 99133, 99137, 99139};

    private CheckIfPrime cNone, cPrime;

    public CheckIfPrimeTest() {
        cNone = new CheckIfPrime(testNumbersNoPrimes);
        cPrime = new CheckIfPrime(testNumbersPrimes);
    }

    /**
     * Test of checkIfSingleNumberIsPrime method, of class CheckIfPrime.
     */
    @Test
    public void testCheckIfSingleNumberIsPrime() {
        for (int i : testNumbersNoPrimes) {
            assertFalse("This is not a prime number, your program should recognize this.", cNone.checkIfSingleNumberIsPrime(i));
        }

        for (int i : testNumbersPrimes) {
            assertTrue("This is a prime number, your program should recognize this.", cPrime.checkIfSingleNumberIsPrime(i));
        }
    }

    /**
     * Test of checkIfNumbersInArrayArePrime method, of class CheckIfPrime.
     */
    @Test
    public void testCheckIfNumbersInArrayArePrime() {
        String[] expResultNoPrimes = {"0: false", "1: false",
            "10: false", "78900: false",
            "10098: false", "1068: false",
            "10000001: false"};
        String[] expResultPrimes = {"2: true", "10007: true",
            "99083: true", "99089: true",
            "10093: true", "99109: true",
            "99119: true", "99131: true",
            "99133: true", "99137: true",
            "99139: true"};

        int i = 0;
        for (String s : cNone.checkIfNumbersInArrayArePrime()) {
            assertEquals("This is not a prime number, your program should recognize this.", expResultNoPrimes[i], s);
            i++;
        }
        i = 0;
        for (String s : cPrime.checkIfNumbersInArrayArePrime()) {
            assertEquals("This is a prime number, your program should recognize this.", expResultPrimes[i], s);
            i++;
        }
    }
}