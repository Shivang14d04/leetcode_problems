import java.util.Arrays;

public class PalindromePartitioningII{

    // memoization
     public int minCut(String s) {

        int n = s.length();
        int [] dp = new int[n];
       
            Arrays.fill(dp,-1);
        

        return helper(s,0,dp) -1;
        
    }

    public int helper(String s , int i  ,int[] dp){
        if(i==s.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int min  = Integer.MAX_VALUE;

        for(int j = i;j<s.length();j++){
            if(isPalindrome(s,i,j)){
               int ans = 1 + helper(s,j+1,dp);
               min  = Math.min(ans,min);
            }
            
        }
        dp[i]  = min;
        return dp[i];

    }
    public boolean isPalindrome(String str,int i , int j){
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // tabulation
    public int minCut2(String s) {

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

}