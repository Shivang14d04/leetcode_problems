import java.util.HashMap;

class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        return solution(n);
    }

    public int solution(int n) {
        if (n == 0) {
            return 0;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            min = Math.min(min, solution(n - square) + 1);
        }

        memo.put(n, min);
        return min;
    }
}
