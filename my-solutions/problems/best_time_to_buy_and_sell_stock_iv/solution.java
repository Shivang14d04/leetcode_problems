class Solution {
    public int maxProfit(int k, int[] prices) {
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