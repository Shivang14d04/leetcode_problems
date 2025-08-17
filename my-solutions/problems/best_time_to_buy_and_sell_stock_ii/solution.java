class Solution {
    public int maxProfit(int[] prices) {
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
                    profit = Math.max((-prices[i] + prev[1]), (0 +prev[0]));
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