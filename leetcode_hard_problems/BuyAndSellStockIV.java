import java.util.Arrays;
public class BuyAndSellStockIV {
    // memoization
     public int maxProfit(int k, int[] prices) {
        int n= prices.length;

        int[][][] dp = new int[n+1][2][k+1];

        for(int i = 0;i<=n;i++){
            for(int j = 0;j<2;j++){
                Arrays.fill(dp[i][j] ,-1);
            }
        }
        return helper(dp,0,prices,0,k);
    }
    public int helper(int[][][] dp ,int index,int[] prices,int buy,int k){
        if(index == prices.length || k==0){
            return 0;
        }
        if(dp[index][buy][k] != -1){
            return dp[index][buy][k];
        }
        int profit = 0;
        if(buy==0){
            profit = Math.max((-prices[index] + helper(dp,index+1,prices,1,k))  ,(0+helper(dp,index+1,prices,0,k)));
        }
        if(buy==1){
            profit  = Math.max((prices[index] + helper(dp,index+1,prices,0,k-1)) , (0+helper(dp,index+1,prices,1,k)));
        }

       return  dp[index][buy][k] = profit;
        
    }
    // tabulation
      public int maxProfit2(int k, int[] prices) {
  int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int maxTr = 1; maxTr <= k; maxTr++) {
                    if (buy == 0) {
                        dp[index][buy][maxTr] = Math.max((-prices[index] + dp[index + 1][1][maxTr]),
                                (0 + dp[index + 1][0][maxTr]));
                    }
                    if (buy == 1) {
                        dp[index][buy][maxTr] = Math.max((prices[index] + dp[index + 1][0][maxTr - 1]),
                                (0 + dp[index + 1][1][maxTr]));
                    }
                }

            }
        }
        return dp[0][0][k];
    }
    // space optimization
    
     public int maxProfit3(int k, int[] prices) {
          int n = prices.length;

        int[][] ahead = new int[2][k+1];
        int [][] curr = new int[2][k+1];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int maxTr = 1; maxTr <= k; maxTr++) {
                    if (buy == 0) {
                        curr[buy][maxTr] = Math.max((-prices[index] + ahead[1][maxTr]),
                                (0 + ahead[0][maxTr]));
                    }
                    if (buy == 1) {
                        curr[buy][maxTr] = Math.max((prices[index] + ahead[0][maxTr - 1]),
                                (0 + ahead[1][maxTr]));
                    }
                }

            }
            ahead = curr;

        }
        return ahead[0][k];

    }
}
