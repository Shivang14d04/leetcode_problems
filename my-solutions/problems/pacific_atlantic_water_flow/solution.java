class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean [][]  atl = new boolean[row][col];
        boolean [][]  pac = new boolean[row][col];

        for(int i =0;i<col;i++){
            dfs(0,i,pac,heights);
            dfs(row-1,i,atl,heights);
        }

        for(int i  = 0;i<row;i++){
            dfs(i,0,pac,heights);
            dfs(i,col-1,atl,heights);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(atl[i][j] && pac[i][j]) ans.add(Arrays.asList(i,j));
            }
        }
        return ans;
    }

    public void dfs(int row , int col, boolean[][] vis, int[][] heights){
        vis[row][col] = true;
        int[] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        for(int i =0;i<4;i++){
            int r = row + dx[i];
            int c = col + dy[i];
            if(r>=0 && c>=0 && r<heights.length && c <heights[0].length && !vis[r][c] && heights[r][c]>= heights[row][col]) dfs(r,c,vis,heights);
        }
    }
}