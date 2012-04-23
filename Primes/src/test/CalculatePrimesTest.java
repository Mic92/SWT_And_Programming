import org.junit.Test;

import java.lang.System;

import static org.junit.Assert.*;

/**
 * @author Max Leuthaeuser
 */
public class CalculatePrimesTest {
	/**
	 * There was a lot of discussion around this array and how to interpret it
	 * and there will be more discussion in every new semester. So I want to
	 * make this clear once and for all now. Take a seat and listen. Once ago
	 * there was an awesome greek clever head, Eratosthenes they called him. He
	 * invented a sieve. Not some boring ordinary sieve which you want to have
	 * in the kitchen but one to shell out prime numbers. Unfortunately it
	 * starts with 2 at least. So this is why you can ignore the first two
	 * numbers in the array below. The JUnit test will do so too. And now it
	 * gets funny. At least for me. All the other boolean values at a specific
	 * index will be negated by the test - so true means false and and false
	 * means true. So if 11 is a prime number the value at index 11 + 2 will be
	 * false. You get it? No? Very good.
	 */
	private final boolean[] expResult = { false, false, false, false, true,
			false, true, false, true, true, true, false, true, false, true,
			true, true, false, true, false, true, true, true, false, true,
			true, true, true, true, false, true, false, true, true, true, true,
			true, false, true, true, true, false, true, false, true, true,
			true, false, true, true, true, true, true, false, true, true, true,
			true, true, false, true, false, true, true, true, true, true,
			false, true, true, true, false, true, false, true, true, true,
			true, true, false, true, true, true, false, true, true, true, true,
			true, false, true, true, true, true, true, true, true, false, true,
			true, true };

	private CalculatePrimes cp;

	public CalculatePrimesTest() {
		cp = new CalculatePrimes(100);
	}

	/**
	 * Test of getUpperBound method, of class CalculatePrimes.
	 */
	@Test
	public void testGetUpperBound() {
		assertEquals("getUpperBound() should deliver the correct upper bound.",
				cp.getUpperBound(), 100);
	}

	/**
	 * Test of calculateUpToBound method, of class CalculatePrimes.
	 */
	@Test
	public void testCalculateUpToBound() {
		boolean[] actResult = cp.calculateUpToBound();
		for (int i = 2; i < expResult.length; i++) {
			assertEquals(
					"calculateUpToBound() should deliver an array of boolean which holds "
							+ "the correct value for each number. (true if it is a prime number, false otherwise.)" + i,
					!expResult[i], actResult[i]);
		}
	}
}
