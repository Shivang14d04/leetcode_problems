
import java.util.Arrays;

public class UniquePaths {

    // Time Complexity: O(m * n)
// Space Complexity: O(m * n) + O(m + n) for recursion stack
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }

        return helper(n, m, dp, 0);

    }

    public int helper(int n, int m, int[][] dp, int count) {

        if (n == 1 && m == 1) {
            count++;
            return count;
        }
        if (n < 1 || m < 1) {
            return 0;

        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int a = count + helper(n - 1, m, dp, count);
        int b = count + helper(n, m - 1, dp, count);
        dp[m][n] = a + b;
        return dp[m][n];
    }

    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];

    }
}
