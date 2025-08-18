import java.util.Arrays;

public class BuyAndSellStockIII {
    // Memoization
        public int maxProfit(int[] prices) {
        int n = prices.length;
       

        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(dp,0,0,2,prices);
    }

    public int helper(int[][][] dp, int index, int buy, int maxTr, int[] prices) {
        if (index == prices.length || maxTr == 0) {
            return 0;
        }

        if (dp[index][buy][maxTr] != -1) {
            return dp[index][buy][maxTr];
        }
        int profit = 0;

        if (buy == 0) {
            profit = Math.max((-prices[index] + helper(dp, index + 1, 1, maxTr, prices)),
                    (0 + helper(dp, index + 1, 0, maxTr, prices)));
        }
        if(buy==1){
            profit = Math.max((prices[index] + helper(dp, index + 1, 0, maxTr-1, prices)),
                    (0 + helper(dp, index + 1, 1, maxTr, prices)));
        }

        return dp[index][buy][maxTr] = profit;
    }
    // tabulation
     public int maxProfit2(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int maxTr = 1; maxTr <= 2; maxTr++) {
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
        return dp[0][0][2];

    }
    // Space Optimization
        public int maxProfit3(int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][3];
        int [][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int maxTr = 1; maxTr <= 2; maxTr++) {
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
        return ahead[0][2];

    }
}
