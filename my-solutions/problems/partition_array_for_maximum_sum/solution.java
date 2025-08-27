class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
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