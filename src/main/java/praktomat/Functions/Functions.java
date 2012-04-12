public class Functions {
    public static int faculty(int n) {
        if (n <= 1) return 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    public static void main(String args[]) {

    }
}
