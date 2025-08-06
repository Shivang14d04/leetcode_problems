
import java.util.Arrays;

public class MinimumPathSum {

    //time complexity : O(m * n)
    //space complexity : O(m * n) + O(m + n) for recursion stack
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper(grid, dp, m - 1, n - 1);

    }

    public int helper(int[][] grid, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = grid[i][j] + helper(grid, dp, i - 1, j);
        int left = grid[i][j] + helper(grid, dp, i, j - 1);
        dp[i][j] = Math.min(up, left);
        return dp[i][j];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return helper2(grid, dp, m - 1, n - 1);

    }

    public int helper2(int[][] grid, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = helper(grid, dp, i - 1, j);
        int left = helper(grid, dp, i, j - 1);
        int minPath = Math.min(up, left);
        if (minPath == Integer.MAX_VALUE) {
            dp[i][j] = Integer.MAX_VALUE;
        } else {
            dp[i][j] = grid[i][j] + minPath;
        }
        return dp[i][j];
    }

}
