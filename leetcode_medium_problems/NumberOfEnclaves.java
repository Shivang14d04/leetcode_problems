public class NumberOfEnclaves{
      public int numEnclaves(int[][] grid) {
            int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int [][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            if(grid[i][0] == 1){
                dfs(i,0,visited,grid,n,m);
            }
        }
        for(int i = 0;i<m;i++){
            if(grid[0][i] == 1){
                dfs(0,i,visited,grid,n,m);
            }
        }
        for(int i = 0;i<m;i++){
            if(grid[n-1][i] == 1){
                dfs(n-1,i,visited,grid,n,m);
            }
        }
        for(int i = 0;i<n;i++){
            if(grid[i][m-1] == 1){
                dfs(i,m-1,visited,grid,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(visited[i][j] ==0 && grid[i][j] != 0){
                    count++;
                }
            }
        }   

        return count;                   


    }

    public void dfs(int row , int col , int[][] visited , int[][] grid,int n ,int m){
        visited[row][col] = 2;

        int[] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1} ;

        for(int  i = 0;i<4;i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if(nrow>=0 && ncol>=0 && nrow< n && ncol <m && visited[nrow][ncol]==0 && grid[nrow][ncol] ==1){
              
                dfs(nrow, ncol, visited, grid,n,m);
            }
        }

    }
}