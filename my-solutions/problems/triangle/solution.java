class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int [][] dp = new int [m][n];

        for(int [] a : dp){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        return helper(dp ,0 ,0,triangle);


        
    }
    public int helper(int[][] dp , int i , int j,List<List<Integer>> triangle){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }


        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = triangle.get(i).get(j) +  helper(dp , i+1 ,j,triangle);
        int right = triangle.get(i).get(j) + helper(dp , i +1 ,j+1,triangle);

        dp[i][j] = Math.min(left,right);
        return dp[i][j];
    }
}