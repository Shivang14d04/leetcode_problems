public class DeleteOperationForTwoStrings {
    // tabulation approach
    // this approach uses O(n * m) space
       public int minDistance(String word1, String word2) {
        int n  = word1.length();
        int m = word2.length();

        int [][] dp = new int[n+1][m+1];

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return (n-  dp[n][m])+ (m -  dp[n][m]);
    }
    // space optimized approach
    // this approach uses O(m) space
      public int minDistance2(String word1, String word2) {
        int n  = word1.length();
        int m = word2.length();

        int []prev = new int[m+1];

        for(int i = 1;i<=n;i++){
            int [] curr = new int[m+1];
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = 1+ prev[j-1];
                }
                else{
                    curr[j] = Math.max(prev[j] , curr[j-1]);
                }
            }

            prev = curr;
        }
        return (n- prev[m])+ (m - prev[m]);
    }
}
