
class Solution {

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
}
