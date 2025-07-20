
class Solution1 {

    //Brute force solution
    public int countGoodNumbers(long n) {
        boolean cal = true;
        long ans = 1;
        int mod = 1_000_000_007;

        while (n > 0) {
            if (cal) {
                ans = (ans * 5) % mod;

            } else {
                ans = (ans * 4) % mod;

            }

        }
        cal = !cal;
        n = n - 1;
        return (int) ans;
    }
// Optimized Solution (O(log(n))) time complexity

    int mod = 1_000_000_007;

    public int countGoodNumbers_OtmizedSolution(long n) {

        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 20;
        }
        long even = n / 2;
        long odd = n - even;

        long a = helper(even, 4);
        long b = helper(odd, 5);
        return (int) ((a * b) % mod);
    }

    public long helper(long n, long y) {
        long result = 1;
        y = y % mod;

        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * y) % mod;
            }
            y = (y * y) % mod;
            n = (n / 2);
        }
        return result;
    }

}

// Optimized Solution 

