class Solution {
    public int minCut(String s) {

        int n = s.length();
        int[] dp = new int[n+1];

        for (int i = n - 1; i >= 0; i--) {
             int min = Integer.MAX_VALUE;
            for (int j = i; j <n; j++) {
               

                if (isPalindrome(s, i, j)) {
                    int ans = 1 + dp[j + 1];
                    min = Math.min(ans, min);
                }
                

            }
            dp[i] = min;
        }
        return dp[0] -1;

    }

    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}