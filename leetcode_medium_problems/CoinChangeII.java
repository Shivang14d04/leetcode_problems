
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
}
