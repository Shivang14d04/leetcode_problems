class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solution(nums, 0, target);
    }

    public int solution(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Include +nums[i]
        int add = solution(nums, i + 1, target - nums[i]);

        // Include -nums[i]
        int subtract = solution(nums, i + 1, target + nums[i]);

        return add + subtract;
    }
}
