class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
      int n = mat.length;
      int m = mat[0].length;
      int [][] ans = new int [r][c];
      int [] ans1   = new int[n*m];
      if(n*m!=r*c){
    return mat;
      }  
      int k=0;
      for(int i = 0;i<n;i++){
        for(int j =0;j<m;j++){
        ans1[k] = mat[i][j];
        k++;
        }
      }
      for(int i = 0;i<ans1.length;i++){
        ans[i/c][i%c] = ans1[i];
      }
      return ans;
    }
}