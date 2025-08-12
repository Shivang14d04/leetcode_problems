class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        final int INF = (int) 1e9;
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0];
            } else {
                prev[i] = INF;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int skip = prev[j];
                int keep = INF;
                if (coins[i] <= j) {
                    keep = 1 + curr[j - coins[i]];
                }
                curr[j] = Math.min(keep, skip);
            }
            prev = curr;
        }

        int ans = prev[amount];
        return (ans >= INF) ? -1 : ans;
    }
}
