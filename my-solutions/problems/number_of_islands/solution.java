class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int  m = grid[0].length;
        int[][] visited = new int[n][m];
        int count =0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && visited[i][j] ==0){

                  dfs(visited,i,j,grid); 
                  count++; 
                }
            }
        }
        return count;
        
    }
    public void dfs(int[][] visited , int row, int col , char [][] grid){
        visited[row][col]  = 1;
        int[] dx = {-1,0,1,0};
        int[] dy  = {0,-1,0,1};
        for(int i = 0;i<4;i++){
            int nrow = row+ dx[i];
            int ncol = col + dy[i];

            if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol< grid[0].length && visited[nrow][ncol] == 0 && grid[nrow][ncol] =='1'){
                dfs(visited,nrow,ncol,grid);
            }
        }
    }
}