class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] vis = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int [][] vis , char[][] grid){
        vis[row][col] = 1;
        int[] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        for(int i =0;i<4;i++){
            int r = row+ dx[i];
           int  c = col + dy[i];
            if(r>=0 && c>=0 && r< grid.length && c< grid[0].length && vis[r][c]==0 && grid[r][c]=='1'){
                 dfs(r,c,vis,grid);
            }
        }
    }
}