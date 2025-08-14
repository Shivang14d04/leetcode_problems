
import java.util.Arrays;

public class LongestCommonSubsequence {
    // Time complexity: O(n * m)
    // Space complexity: O(n * m) + O(n + m)

    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(dp, text1, text2, n - 1, m - 1);

    }

    public int helper(int[][] dp, String text1, String text2, int index1, int index2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return dp[index1][index2] = 1 + helper(dp, text1, text2, index1 - 1, index2 - 1);
        }
        return dp[index1][index2] = Math.max(helper(dp, text1, text2, index1, index2 - 1), helper(dp, text1, text2, index1 - 1, index2));

    }

    // tabulation approach
    // this approach uses O(n * m) space
    public int longestCommonSubsequence2(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int index1 = 1; index1 <= n; index1++) {
            for (int index2 = 1; index2 <= m; index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1][index2 - 1], dp[index1 - 1][index2]);
                }
            }
        }
        return dp[n][m];

    }

    // space optimized approach
    // this approach uses O(m) space
    public int longestCommonSubsequence3(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m + 1];

        for (int index1 = 1; index1 <= n; index1++) {
            int[] curr = new int[m + 1];
            for (int index2 = 1; index2 <= m; index2++) {
                if (text1.charAt(index1 - 1) == text2.charAt(index2 - 1)) {
                    curr[index2] = 1 + prev[index2 - 1];
                } else {
                    curr[index2] = Math.max(curr[index2 - 1], prev[index2]);
                }
            }
            prev = curr;
        }
        return prev[m];

    }
}
