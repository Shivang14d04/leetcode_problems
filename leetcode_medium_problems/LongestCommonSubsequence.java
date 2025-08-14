
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
}
