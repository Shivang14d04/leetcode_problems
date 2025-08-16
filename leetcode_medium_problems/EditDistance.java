import java.util.Arrays;

public class EditDistance {
    // memoization approach
     public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int [][] dp = new int[n+1][m+1];
        for(int [] a: dp){
            Arrays.fill(a,-1);
        }
        return helper(dp , word1,word2,n-1,m-1);
        
    }
    public int helper(int[][] dp , String word1, String word2,int i,int j){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(word1.charAt(i)== word2.charAt(j)){
            dp[i][j] = helper(dp,word1,word2,i-1,j-1);
        }
        else{
            dp[i][j] = 1 + Math.min(helper(dp,word1,word2,i-1,j-1),Math.min(helper(dp,word1,word2,i-1,j),helper(dp,word1,word2,i,j-1)));
        }

        return dp[i][j];
    }
    // tabulation approach
        public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];

    }
    // space optimized solution
     public int minDistance3(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[]prev = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }


        for (int i = 1; i <= n; i++) {
            int [] curr = new int[m+1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], curr[j - 1]));
                }
            }
            prev = curr;
        }
        return prev[m];

    }
}
