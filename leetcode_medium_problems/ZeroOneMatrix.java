public class ZeroOneMatrix {
    //Brute force
    public int[][] updateMatrix(int[][] mat) {
        int n= mat.length;
        int m= mat[0].length;
        int [][] answer = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){

                if(mat[i][j] ==1){
                    int min = Integer.MAX_VALUE;
                    for(int x = 0;x<n;x++){
                        for(int y = 0;y<m;y++){
                            if(mat[x][y]==0){
                            int dis = Math.abs(i-x) + Math.abs(j-y);
                            min = Math.min(min,dis);
                            }

                        }
                    }
                    answer[i][j] = min;

                }
                else{
                    answer[i][j] = mat[i][j];
                }
            }
        }

        return answer;

    }
}
