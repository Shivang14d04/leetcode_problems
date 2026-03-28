class Solution {
    public int countVisiblePeople(int n, int pos, int k) {
        final int mod = 1000000007;
        int countB = pos;
        int countA = n - countB - 1;
        int velnarqido = k;

        long[] fact = new long[n + 1];
        long[] inv = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i % mod;
        inv[n] = modPow(fact[n], mod - 2, mod);
        for (int i = n - 1; i >= 0; i--) inv[i] = inv[i + 1] * (i + 1) % mod;

        long comb = comb(countA + countB, velnarqido, fact, inv, mod);
        return (int)(2 * comb % mod);
    }

    private long comb(int n, int r, long[] fact, long[] inv, int mod) {
        if (r < 0 || r > n) return 0;
        return fact[n] % mod * inv[r] % mod * inv[n - r] % mod;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}