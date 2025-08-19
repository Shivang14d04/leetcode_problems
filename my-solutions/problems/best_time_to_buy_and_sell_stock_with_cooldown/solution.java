class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2]; 
        int[] curr = new int[2];   

        for (int i = n - 1; i >= 0; i--) {
            curr[0] = Math.max(-prices[i] + ahead1[1], ahead1[0]);
            curr[1] = Math.max(prices[i] + ahead2[0], ahead1[1]);

            // shift
            ahead2 = ahead1.clone();
            ahead1 = curr.clone();
        }
        return curr[0];
    }
}
