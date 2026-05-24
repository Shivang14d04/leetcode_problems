class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] vis  = new boolean[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(helper(board,i,j,word,vis,0)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean helper(char[][] board,int r , int c, String word, boolean[][] vis, int i){
        if(i== word.length()){
            return true;
        }
        if(r<0 || c<0 || r>vis.length-1 || c> vis[0].length-1 ||word.charAt(i)!=board[r][c] || vis[r][c]==true){
            return false;
        }
        vis[r][c] = true;
        boolean ans =  helper(board,r+1,c,word,vis,i+1)||helper(board,r,c+1,word,vis,i+1)||helper(board,r-1,c,word,vis,i+1)||helper(board,r,c-1,word,vis,i+1);
        vis[r][c] = false;
        return ans;
    }
}