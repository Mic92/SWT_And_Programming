import java.util.Arrays;
class CalculatePrimes {
    private final int mUpperBound;
    CalculatePrimes(int upperBound) {
        mUpperBound = upperBound;
    }
    int getUpperBound() {
        return mUpperBound;
    }
    boolean[] calculateUpToBound() {
        boolean[] res = new boolean[mUpperBound + 1];
        Arrays.fill(res, true);
        // src: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Implementation
        for (int i = 2; i <= mUpperBound/2; i++) {
            if (res[i]) {
                for (int j = 2*i; j <= mUpperBound; j+=i) {
                    res[j] = false;
                }
            }
        }
        return res;
    }
}
