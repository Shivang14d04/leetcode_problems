
import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] ans = new int[n];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], nums[i] + ans[i - 2]);
        }
        return ans[n - 1];
    }

    // Memoization approach
    public int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);

    }

    public int helper(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int take = nums[index] + helper(nums, index + 2, dp);
        int skip = helper(nums, index + 1, dp);

        dp[index] = Math.max(take, skip);
        return dp[index];
    }

    // Tabulation approach
    public int rob3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick = pick + dp[i - 2];
            }

            int skip = dp[i - 1];
            dp[i] = Math.max(pick, skip);
        }
        return dp[n - 1];

    }

    // Space optimized approach
    public int rob4(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick = pick + prev2;
            }

            int skip = prev;
            int current = Math.max(pick, skip);
            prev2 = prev;
            prev = current;

        }
        return prev;

    }
}
