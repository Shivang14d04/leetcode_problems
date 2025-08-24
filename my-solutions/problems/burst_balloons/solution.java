class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int a : nums) {
            list.add(a);
        }
        list.add(1);
        list.add(0, 1);
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n ; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;

                int max = Integer.MIN_VALUE;

                for (int index = i; index <= j; index++) {
                    int ans = list.get(i - 1) * list.get(index) * list.get(j + 1) + dp[i][index - 1]
                            + dp[index + 1][j];

                    max = Math.max(max, ans);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];

    }

}