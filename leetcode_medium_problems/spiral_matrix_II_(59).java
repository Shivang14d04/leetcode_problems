class Solution {
    public int[][] generateMatrix(int n) {
       int rows  = n;
       int cols = n;
       int r = 0;
       int c = -1 ;
       int direction =1;
       int count =1;
       int [][] result = new int[n][n];
       while(count<=n*n){
        for(int i =0;i<cols;i++){
            c+=direction;
            result[r][c]= count;
            count++;
        }
        rows--;
        for(int i =0;i<rows;i++){
        
            r+=direction;
            result[r][c]= count;
            count++;
        }
        cols--;
        direction *=-1;
       }
       return result; 
    }
}