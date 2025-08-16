import java.util.Arrays;

public class DistinctSubsequences {
    // memoization
    // time complexity: O(n * m)
    // space complexity: O(n * m)
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s, t, n - 1, m - 1, dp);
    }

    private int helper(String s, String t, int i, int j, int[][] dp) {
        // if t is finished, found one subsequence
        if (j < 0) return 1;
        // if s finished but t not
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int notTake = helper(s, t, i - 1, j, dp);
        int take = 0;
        if (s.charAt(i) == t.charAt(j)) {
            take = helper(s, t, i - 1, j - 1, dp);
        }

        return dp[i][j] = take + notTake;
    }

    // tabulation approach
    // time complexity: O(n * m)
    // space complexity: O(n * m)
    public int numDistinct2(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    // space complexity: O(n * m)
    // optimized space complexity: O(m)
    public int numDistinct3(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m];
    }
}
