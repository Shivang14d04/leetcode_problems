
import java.util.Arrays;

public class MinimumFallingPathSum {
    // Time complexity: O(n^2)
    // Space complexity: O(n^2) + O(n) for recursion stack

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];

        for (int[] a : dp) {
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            minSum = Math.min(minSum, helper(dp, 0, j, matrix));
        }

        return minSum;
    }

    public int helper(int[][] dp, int row, int col, int[][] matrix) {
        int n = matrix.length;

        if (col < 0 || col >= n) {
            return Integer.MAX_VALUE;
        }

        if (row == n - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int left = helper(dp, row + 1, col - 1, matrix);
        int down = helper(dp, row + 1, col, matrix);
        int right = helper(dp, row + 1, col + 1, matrix);

        dp[row][col] = matrix[row][col] + Math.min(left, Math.min(down, right));
        return dp[row][col];
    }
}
