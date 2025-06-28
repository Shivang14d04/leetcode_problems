class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       int rows  = matrix.length;
       int cols = matrix[0].length;
       int r = 0;
       int c = -1 ;
       int direction =1;
       ArrayList<Integer> result = new ArrayList<>();
       while(rows>0 && cols>0){
        for(int i =0;i<cols;i++){
            c+=direction;
            result.add(matrix[r][c]);
        }
        rows--;
        for(int i =0;i<rows;i++){
            r+=direction;
            result.add(matrix[r][c]);
        }
        direction *=-1;
       }
       return result;

    }
}
