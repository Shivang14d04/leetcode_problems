import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    // memoization
     public int maxProfit(int[] prices, int fee) {
           int n = prices.length;
        if(n==0){
            return 0;
        }
        int [][] dp =  new int[n][2];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        return helper(dp,0,0,prices,fee);       
    }
    public int helper(int[][] dp ,int index , int buy , int[] arr,int fee){
        if(index==arr.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        int profit =0;

        if(buy==0){
            profit = Math.max((-arr[index]-fee + helper(dp,index+1,1,arr,fee)) , (0 + helper(dp,index+1,0,arr,fee)));
        }
        if(buy==1){
            profit = Math.max((arr[index]+helper(dp,index+1,0,arr,fee)),(0+helper(dp,index+1,1,arr,fee)));
        }

         dp[index][buy] = profit;
        return profit;
    }
    // tabulation
        public int maxProfit2(int[] prices, int fee) {
   int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n+1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max((-prices[i]-fee + dp[i + 1][1]), (0 + dp[i + 1][0]));
                }
                if (buy == 1) {
                    profit = Math.max((prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    } 
    // space optimization
     public int maxProfit3(int[] prices, int fee) {
   int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[]prev = new int[2];
        


        prev[0] = prev[1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            int[] curr  = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max((-prices[i]-fee + prev[1]), (0 +prev[0]));
                }
                if (buy == 1) {
                    profit = Math.max((prices[i] + prev[0]), (0 + prev[1]));
                }
                curr[buy] = profit;
            }
            prev = curr;
        }
        return prev[0];
    }  
}
