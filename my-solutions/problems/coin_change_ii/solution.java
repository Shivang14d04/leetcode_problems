class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[]prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount+1];
            for (int target = 0; target <= amount; target++) {
                int skip = prev[target];
                int take = 0;

                if (coins[i] <= target) {
                    take = curr[target - coins[i]];
                }

                curr[target] = take + skip;
            }
            prev = curr;
        }

        return prev[amount];

    }

}