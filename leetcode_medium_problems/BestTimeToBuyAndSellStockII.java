import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
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
        if(index==arr.length){
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
            profit = Math.max((arr[index]+helper(dp,index+1,0,arr)),(0+helper(dp,index+1,1,arr)));
        }

         dp[index][buy] = profit;
        return profit;
    }
}
