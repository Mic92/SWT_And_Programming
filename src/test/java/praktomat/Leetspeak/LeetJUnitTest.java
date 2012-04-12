import junit.framework.TestCase;

public class LeetJUnitTest extends TestCase
{

    public void test()
    {
        String[] org = new String[]
        { "1eet", "cool", "!", "ck", "ers", "er", "en", "e", "t", "o", "a", };
        String[] res = new String[]
        { "1337", "k3wl", "!!!11", "xx", "0rz", "0rz", "n", "3", "7", "0", "@", };

        // check the basic replacements
        for (int i = 0; i < org.length; i++)
        {
            //System.out.println(res[i] + " == " + Leet.toLeet(org[i]) );
            assertEquals(res[i], Leet.toLeet(org[i]));
        }

        String[] x = new String[]
        { "We are elite hackers!", "Informatiker machen tolle Sachen!" };
        String[] y = new String[]
        { "W3 @r3 1337 h@xx0rz!!!11", "Inf0rm@7ik0rz m@chn 70ll3 S@chn!!!11" };

        String[] z = Leet.allToLeet(x);
        // check length of result array
        assertEquals(x.length, z.length);

        // check resulting strings
        for (int i = 0; i < x.length; i++)
        {
            //System.out.println(y[i] + " == " + z[i] );
            assertEquals(y[i], z[i]);
        }

    }
}
