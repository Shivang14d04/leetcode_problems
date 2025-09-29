class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int rows = matrix.length ;
       int cols  = matrix[0].length;
       List<Integer> ans  = new ArrayList<>();
       int direc = 1;
       int r = 0;
       int c = -1;
       while(rows>0 && cols>0){
        for(int i  =0;i< cols;i++){
            c+= direc;
            ans.add(matrix[r][c]);
        }
        rows--;
        for(int i =0;i< rows;i++){
            r+=direc;
            ans.add(matrix[r][c]);
        }
        cols--;
        direc*=-1;

       }
       return ans;

    }
}