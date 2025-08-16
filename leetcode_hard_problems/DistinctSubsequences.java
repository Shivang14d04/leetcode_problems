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
}
