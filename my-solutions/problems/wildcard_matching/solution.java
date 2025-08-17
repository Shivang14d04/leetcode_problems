import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m + 1];

        // base case: empty string and empty pattern
        prev[0] = true;

        // initialize first row: s = "" vs pattern prefix
        for (int j = 1; j <= m; j++) {
            prev[j] = isAllStars(p, j);
        }

        // fill dp row by row
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            curr[0] = false; // non-empty string can't match empty pattern

            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    // helper: check if first j chars in pattern are all '*'
    private boolean isAllStars(String p, int j) {
        for (int k = 0; k < j; k++) {
            if (p.charAt(k) != '*') return false;
        }
        return true;
    }
}
