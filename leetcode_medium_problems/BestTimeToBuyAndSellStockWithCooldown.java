import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {
    // memoization
      public int maxProfit(int[] prices) {
           int n = prices.length;
        if(n==0){
            return 0;
        }
        int [][] dp =  new int[n][2];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }

        return helper(dp,0,0,prices);       
    }
    public int helper(int[][] dp ,int index , int buy , int[] arr){
        if(index>=arr.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }

        int profit =0;

        if(buy==0){
            profit = Math.max((-arr[index] + helper(dp,index+1,1,arr)) , (0 + helper(dp,index+1,0,arr)));
        }
        if(buy==1){
            profit = Math.max((arr[index]+helper(dp,index+2,0,arr)),(0+helper(dp,index+1,1,arr)));
        }

         dp[index][buy] = profit;
        return profit;
    }
    // tabulation
      public int maxProfit2(int[] prices) {
   int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n+2][2];

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    profit = Math.max((-prices[i] + dp[i + 1][1]), (0 + dp[i + 1][0]));
                }
                if (buy == 1) {
                    profit = Math.max((prices[i] + dp[i + 2][0]), (0 + dp[i + 1][1]));
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }
    // space optimization
      public int maxProfit3(int[] prices) {
        int n = prices.length;
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2]; 
        int[] curr = new int[2];   

        for (int i = n - 1; i >= 0; i--) {
            curr[0] = Math.max(-prices[i] + ahead1[1], ahead1[0]);
            curr[1] = Math.max(prices[i] + ahead2[0], ahead1[1]);

            
            ahead2 = ahead1.clone();
            ahead1 = curr.clone();
        }
        return curr[0];
    }
}
