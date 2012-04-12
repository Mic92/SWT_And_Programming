import junit.framework.TestCase;


public class FunctionsJUnitTest extends TestCase
{

    public void test()
    {
        int[] values = new int[]
        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i = 0; i < values.length; i++)
        {
            assertEquals(fakultaet(values[i]), Functions.faculty(values[i]));
        }
    }

    public int fakultaet(int n)
    {
        if (n == 0)
            return 1;
        else
            return n * fakultaet(n - 1 * Integer.signum(n));
    }
}
