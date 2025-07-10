class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);


        return Math.min(helper(cost,0,dp) , helper(cost,1,dp));

        
    }
    public int helper(int[] cost , int i, int [] dp){
        if(i>=cost.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }

       return dp[i]= cost[i] + Math.min(helper(cost , i+1, dp) , helper(cost,i+2 ,dp));

    }
}