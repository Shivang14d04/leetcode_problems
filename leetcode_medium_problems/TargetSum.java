
import java.util.*;

public class TargetSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int target = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(solution(nums, 0, target));

    }

    public static int solution(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Include +nums[i]
        int add = solution(nums, i + 1, target - nums[i]);

        // Include -nums[i]
        int subtract = solution(nums, i + 1, target + nums[i]);

        return add + subtract;

    }

    // Memoization approach
    // Time complexity: O(n * target)   
    // Space complexity: O(n * target)
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        if (totalSum - target < 0) {
            return 0;
        }

        if ((totalSum - target) % 2 == 1) {
            return 0;
        }
        int s2 = (totalSum - target) / 2;

        int[][] dp = new int[n][s2 + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);

        }

        return helper(dp, s2, nums, n - 1);
    }

    public int helper(int[][] dp, int target, int[] nums, int index) {
        if (index == 0) {
            if (target == 0 && nums[0] == 0) {
                return 2;
            }
            if (target == 0 || nums[0] == target) {
                return 1;
            }

            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = helper(dp, target, nums, index - 1);

        int take = 0;
        if (nums[index] <= target) {
            take = helper(dp, target - nums[index], nums, index - 1);
        }

        dp[index][target] = take + notTake;
        return dp[index][target];

    }
}
