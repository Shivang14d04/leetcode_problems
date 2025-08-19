import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // memoization
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return helper(dp,0,-1,nums);
        
    }
    public int helper(int[][] dp , int index, int prevIndex,int[] nums){
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prevIndex+1] != -1){
            return dp[index][prevIndex+1];
        }

        int notTake = helper(dp, index+1,prevIndex,nums);
        int take = 0;
        if(prevIndex == -1 || nums[index]>nums[prevIndex]){
            take  = 1 + helper(dp , index+1,index,nums);
        }

        dp[index][prevIndex+1]  = Math.max(take , notTake);
        return dp[index][prevIndex+1];
    }
}
