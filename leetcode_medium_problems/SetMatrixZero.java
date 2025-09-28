public class SetMatrixZero {
    // time complexity: O(m*n*(m+n))
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
    // time complexity: O(m*n)
     public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int [] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                     row[i] = 1;
                     col[j] = 1;

                }
            }
        }
        for (int i = 0; i < m; i++) {
            if(row[i]==1){
                for(int j  =0;j<n;j++){
                    matrix[i][j] = 0;
                }
            }
        }
         for (int i = 0; i < n; i++) {
            if(col[i]==1){
                for(int j  =0;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
    // space optimized
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                   matrix[i][0] = 0;
                    if(j !=0){
                        matrix[0][j] =0;
                    }
                    else{
                        col = 0;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    if(matrix[i][0] ==0 || matrix[0][j]==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }        
        if(matrix[0][0]==0){
            for(int i = 0;i<n;i++){
                matrix[0][i]  =0;

            }

        }
        if(col==0){
            for(int i = 0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }

}