class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,1);

        for(int i = 0;i<n;i++){
            for(int prevIndex = 0;prevIndex<=i-1;prevIndex++){
                if(nums[prevIndex]< nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[prevIndex]);
                }
            }
        }
        int ans =-1;
        for(int i = 0;i<n;i++){
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}