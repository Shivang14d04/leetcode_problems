
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));

    }

    public int helper(int[] nums, int start, int end) {
        int prev = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int pick = nums[i];

            pick = pick + prev2;

            int skip = prev;
            int current = Math.max(pick, skip);
            prev2 = prev;
            prev = current;

        }
        return prev;

    }
}
