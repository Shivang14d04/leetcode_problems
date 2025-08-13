
import java.util.*;

public class CoinChangeII {

    // time complexity: O(n * amount)
    // space complexity: O(n * amount) + O(n)
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(dp, amount, n - 1, coins);

    }

    public int helper(int[][] dp, int target, int index, int[] coins) {
        if (index == 0) {
            if (target == 0 && coins[0] == 0) {
                return 2;
            }
            if (target == 0 || target == coins[0]) {
                return 1;
            }
        }
        if (index < 0) {
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int skip = helper(dp, target, index - 1, coins);

        int take = 0;
        if (coins[index] <= target) {
            take = helper(dp, target - coins[index], index, coins);
        }

        dp[index][target] = skip + take;
        return dp[index][target];
    }

    // Tabulation approach
    // Time complexity: O(n * amount)
    // Space complexity: O(n * amount)
    public int change2(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int skip = dp[i - 1][target];
                int take = 0;

                if (coins[i] <= target) {
                    take = dp[i][target - coins[i]];
                }

                dp[i][target] = take + skip;
            }
        }

        return dp[n - 1][amount];

    }

    // Space optimized approach
    // Time complexity: O(n * amount)
    // Space complexity: O(amount)
    public int change3(int amount, int[] coins) {

        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int skip = prev[target];
                int take = 0;

                if (coins[i] <= target) {
                    take = curr[target - coins[i]];
                }

                curr[target] = take + skip;
            }
            prev = curr;
        }

        return prev[amount];

    }
}
