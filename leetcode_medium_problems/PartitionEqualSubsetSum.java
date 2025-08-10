
import java.util.Arrays;

public class PartitionEqualSubsetSum {
    // Time complexity: O(n * k)
    // Space complexity: O(n * k) + O(n) for recursion stack

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        } else {
            int n = nums.length;
            int k = totalSum / 2;
            int[][] dp = new int[n][k + 1];
            for (int[] a : dp) {
                Arrays.fill(a, -1);
            }
            return helper(dp, nums.length - 1, nums, k);
        }
    }

    public boolean helper(int[][] dp, int index, int[] nums, int target) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return nums[0] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }

        boolean notTake = helper(dp, index - 1, nums, target);

        boolean take = false;
        if (nums[index] <= target) {
            take = helper(dp, index - 1, nums, target - nums[index]);
        }

        dp[index][target] = take || notTake ? 1 : 0;
        return dp[index][target] == 1 ? true : false;

    }

}
