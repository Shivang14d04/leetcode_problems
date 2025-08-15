
public class LongestPalindromeSubsequence {
    // tabulation approach
    // this approach uses O(n * m) space
    // where n is the length of the string and m is the length of its reverse
    // time complexity is O(n * m)

    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int m = reversed.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == reversed.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];

    }
}
