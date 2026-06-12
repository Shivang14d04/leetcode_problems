class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for(int i =0;i<row;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
             if(board[i][col-1]=='O'){
                dfs(i,col-1,board);
            }
        }
        for(int i =0;i<col;i++){
            if(board[0][i]=='O'){
                dfs(0,i,board);
            }
             if(board[row-1][i]=='O'){
                dfs(row-1,i,board);
            }
        }

        for(int i=0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(board[i][j] == 'O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }


    }
    public void dfs(int row, int col, char[][] board){
        board[row][col]='T';
        int [] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1};
        for(int i =0;i<4;i++){
            int r = row + dx[i];
            int c = col + dy[i];
            if(r>=0 && c>=0 && r<board.length && c <board[0].length && board[r][c]=='O'){
                dfs(r,c,board);
            }
        }
    }
}