class Solution {
    public double myPow(double x, int n) {
        long N = n; // to handle Integer.MIN_VALUE case
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long n) {
        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
