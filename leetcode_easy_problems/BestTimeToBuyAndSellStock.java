public class BestTimeToBuyAndSellStock {
        public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1;i<prices.length;i++){
            int currProfit = prices[i] - min;
            maxProfit = Math.max(currProfit,maxProfit);
            min  = Math.min(prices[i],min);
        }
        return maxProfit;
        
    }
}
