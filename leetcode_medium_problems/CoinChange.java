
import java.util.*;

public class CoinChange {
    // Time complexity: O(n * amount)
    // Space complexity: O(n * amount)

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        int ans = helper(dp, coins, amount, n - 1);

        if (ans >= (int) Math.pow(10, 9)) {
            return -1;
        } else {
            return ans;
        }

    }

    public int helper(int[][] dp, int[] coins, int target, int index) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int skip = helper(dp, coins, target, index - 1);

        int keep = (int) Math.pow(10, 9);
        if (coins[index] <= target) {
            keep = 1 + helper(dp, coins, target - coins[index], index);
        }

        dp[index][target] = Math.min(keep, skip);
        return dp[index][target];
    }

    // Bottom-up approach
    // Time complexity: O(n * amount)
    // Space complexity: O(n * amount)
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        final int INF = (int) 1e9;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = INF;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int skip = dp[i - 1][j];
                int keep = INF;
                if (coins[i] <= j) {
                    keep = 1 + dp[i][j - coins[i]];
                }
                dp[i][j] = Math.min(keep, skip);
            }
        }

        int ans = dp[n - 1][amount];
        return (ans >= INF) ? -1 : ans;
    }

}
