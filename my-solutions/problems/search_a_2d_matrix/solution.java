class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length,  cols = matrix[0].length;
        int start = 0,  end = rows*cols -1;
        while(start<= end){
            int mid = start +(end-start)/2;
            int r = mid/cols;
            int c = mid%cols;
            if(matrix[r][c]> target){
                end = mid -1;

            }
            else if(matrix[r][c]< target){
                start = mid +1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}