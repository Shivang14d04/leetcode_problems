public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dup = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dup[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    int row = i;
                    int col = j;
                    for (int k = 0; k < n; k++) {
                        dup[row][k] = 0;

                    }
                    for (int c = 0; c < m; c++) {
                        dup[c][col] = 0;

                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = dup[i][j];
            }
        }
    }
}