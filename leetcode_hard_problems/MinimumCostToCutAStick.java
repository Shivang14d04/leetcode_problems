import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {
 public int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for(int b: cuts){
            list.add(b);
        }
        int a = list.size();


        list.add(n);
        list.add(0);
        int[][] dp = new int[a+1][a+1];
        for(int [] k: dp){
            Arrays.fill(k,-1);
        }


        Collections.sort(list);
        return helper(list,1,a,dp);
        
    }
    public int helper( List<Integer> list , int i , int j,int[][]dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int index = i;index<=j;index++){
            int ans = list.get(j+1) - list.get(i-1) + helper(list,i,index-1,dp) + helper(list,index+1,j,dp);
            min  = Math.min(ans,min);
            dp[i][j] = min;
        }
        return dp[i][j];
    }
     public int minCost2(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();
        for (int b : cuts) {
            list.add(b);
        }
        int a = list.size();

        list.add(n);
        list.add(0);
        int[][] dp = new int[a + 2][a + 2];

        Collections.sort(list);
        for (int i = a; i >= 1; i--) {
            for (int j = 1; j <= a; j++) {
                if (i > j) {
                    continue ;
                }
                int min = Integer.MAX_VALUE;
                for (int index = i; index <= j; index++) {
                    int ans = list.get(j + 1) - list.get(i - 1) + dp[i][index-1]
                            + dp[index+1][j];
                    min = Math.min(ans, min);
                    
                }
                dp[i][j] = min;
            }
        }
        return dp[1][a];

    }

}
