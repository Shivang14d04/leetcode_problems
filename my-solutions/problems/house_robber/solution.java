class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.max(helper(dp,0, nums), helper(dp,1, nums));
    }
    public int helper(int [] dp , int i , int [] nums){
        if(i >= nums.length) return 0;
        if(dp[i]!= -1)return dp[i];
        dp[i] = nums[i] + Math.max(helper(dp, i+2, nums), helper(dp,i+3,nums));
        return dp[i];
    }
}