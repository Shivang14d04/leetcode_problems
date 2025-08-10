
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

    // Bottom-up approach
    // Time complexity: O(n * k)
    // Space complexity: O(n * k)
    public boolean canPartition2(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        } else {
            int n = nums.length;
            int k = totalSum / 2;
            boolean[][] dp = new boolean[n][k + 1];
            for (int i = 0; i < nums.length; i++) {
                dp[i][0] = true;
            }

            if (nums[0] <= k) {
                dp[0][nums[0]] = true;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= k; j++) {
                    boolean notTake = dp[i - 1][j];
                    boolean take = false;
                    if (nums[i] <= j) {
                        take = dp[i - 1][j - nums[i]];
                    }

                    dp[i][j] = take || notTake;
                }
            }
            return dp[n - 1][k];

        }
    }

    // Space optimized approach
    // Time complexity: O(n * k)
    // Space complexity: O(k)
    public boolean canPartition3(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        } else {
            int n = nums.length;
            int k = totalSum / 2;
            boolean[] prev = new boolean[k + 1];
            prev[0] = true;

            if (nums[0] <= k) {
                prev[nums[0]] = true;
            }

            for (int i = 1; i < nums.length; i++) {
                boolean[] curr = new boolean[k + 1];
                curr[0] = true;
                for (int j = 1; j <= k; j++) {
                    boolean notTake = prev[j];
                    boolean take = false;
                    if (nums[i] <= j) {
                        take = prev[j - nums[i]];
                    }

                    curr[j] = take || notTake;
                }
                prev = curr;
            }
            return prev[k];

        }
    }

}
