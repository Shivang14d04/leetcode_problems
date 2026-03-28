class Solution {
    public int minCost(int[][] grid) {
       int m = grid.length;
        int n = grid[0].length;
        boolean [][][] dp = new boolean[m][n][1024];

        dp[0][0][grid[0][0]] = true;
        for(int  i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                for(int xor = 0;xor<1024;xor++){
                    if(!dp[i][j][xor]) continue;
                    if(i+1<m){
                        int temp = xor^grid[i+1][j];
                        dp[i+1][j][temp] = true;
                    }
                    if(j+1 <n){
                        int temp = xor^grid[i][j+1];
                        dp[i][j+1][temp] = true;                        
                    }
                }
            }
        }


        for(int i =0;i<1024;i++){
            if(dp[m-1][n-1][i]) return i;
        }
        return -1;
    }
}