
import java.util.*;

public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(climbStairsDP_solution(n));
    }

    private static int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = prev + current;
            prev = temp;
        }
        return current;
    }

    public static int climbStairsDP_solution(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    public static int climbStairs_Tabulation(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
