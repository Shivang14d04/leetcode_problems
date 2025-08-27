import java.util.Arrays;
public class PartitionArrayForMaximumSum {

    // memoization
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n  = arr.length;
        int [] dp =  new int[n];
        Arrays.fill(dp,-1);
        return helper(dp,0,arr,k);
        
    }
    public int helper(int[] dp , int i ,int [] arr , int k){
        if(i==arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int length = 0;
        int max = Integer.MIN_VALUE;
        int maxAnswer = Integer.MIN_VALUE;
        for(int j = i ;j< Math.min(i+k , arr.length);j++){
            length++;
            max = Math.max(arr[j],max);

            int ans = length*max + helper(dp,j+1,arr,k);
            maxAnswer = Math.max(ans,maxAnswer);

        }
        return dp[i] =  maxAnswer;
    }

    // tabulation
    public int maxSumAfterPartitioning2(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int length = 0;
            int max = Integer.MIN_VALUE;
            int maxAnswer = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i + k, arr.length); j++) {
                length++;
                max = Math.max(arr[j], max);

                int ans = length * max + dp[j+1];
                maxAnswer = Math.max(ans, maxAnswer);

            }
            dp[i] = maxAnswer;
        }

        return dp[0];

    }
}