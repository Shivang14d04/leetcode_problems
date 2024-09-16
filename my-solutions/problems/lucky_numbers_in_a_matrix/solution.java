import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Find row minimums
        for (int i = 0; i < rows; i++) {
            int rowMin = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                rowMin = Math.min(rowMin, matrix[i][j]);
            }
            
            // Check if rowMin is the maximum in its column
            boolean isLucky = true;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == rowMin) {
                    int colMax = Integer.MIN_VALUE;
                    for (int k = 0; k < rows; k++) {
                        colMax = Math.max(colMax, matrix[k][j]);
                    }
                    if (rowMin != colMax) {
                        isLucky = false;
                        break;
                    }
                }
            }
            if (isLucky) {
                luckyNumbers.add(rowMin);
            }
        }
        
        return luckyNumbers;
    }
}
