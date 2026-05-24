class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        if (nums.length <= k) return nums;
        int i = k;
        for (int j = k; j < n; j++) {
            if (nums[j] != nums[i - k]) {
                nums[i++] = nums[j];
            }
        }
        
        return Arrays.copyOf(nums, i);
    }
}
