
import java.util.Arrays;

public class UniquePathsII {

    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n) + O(m + n) for recursion stack
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;

        int[][] dp = new int[n][m];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(obstacleGrid, dp, n - 1, m - 1);

    }

    public int helper(int[][] obstacleGrid, int[][] dp, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = helper(obstacleGrid, dp, i - 1, j) + helper(obstacleGrid, dp, i, j - 1);

        return dp[i][j];

    }
}
