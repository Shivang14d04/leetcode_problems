class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m  = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int [][] dis = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] ==0){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = 1;
                }
            }
        }

        int[] rowChange  = {0,-1,0,1};
        int [] colChange = {-1,0,1,0};

        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            int steps = q.peek()[2];
            q.remove();
            dis[row][col] = steps;
            for(int i = 0;i<4;i++){
                int nrow = row + rowChange[i];
                int ncol = col + colChange[i];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol] ==0){
                    q.offer(new int[]{nrow,ncol,steps+1});
                    visited[nrow][ncol] =1;
                }
            }

            
        }

    return dis;
        
    }
}