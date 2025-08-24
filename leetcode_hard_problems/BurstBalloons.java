import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBalloons {

     public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int a : nums){
            list.add(a);
        }
        list.add(1);
        list.add(0,1);
        int n = nums.length;
        int[][] dp = new int[n+2][n+2];
        for(int [] a :dp){
        Arrays.fill(a,-1);}

        return helper(dp,1,nums.length,list);
        
    }
    public int helper(int [][] dp , int i ,int j,List<Integer> list){
if(i>j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;

        for(int index = i;index<=j;index++){
            int ans = list.get(i-1)*list.get(index)*list.get(j+1) + helper(dp,i,index-1,list) + helper(dp,index+1,j,list);

            max = Math.max(max,ans);
        }
        return dp[i][j] = max;
    }
    public int maxCoins2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int a : nums) {
            list.add(a);
        }
        list.add(1);
        list.add(0, 1);
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n ; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;

                int max = Integer.MIN_VALUE;

                for (int index = i; index <= j; index++) {
                    int ans = list.get(i - 1) * list.get(index) * list.get(j + 1) + dp[i][index - 1]
                            + dp[index + 1][j];

                    max = Math.max(max, ans);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];

    }
}