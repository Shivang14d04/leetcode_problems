class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max  = 0;
        for(int i = 0;i<prices.length;i++){
            minPrice = Math.min(prices[i], minPrice);
            max = Math.max(max, prices[i]- minPrice);
        }
        return max;
        
    }
}