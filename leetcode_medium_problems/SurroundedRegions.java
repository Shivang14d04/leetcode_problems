public class SurroundedRegions {
     public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int [][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(i,0,visited,board,n,m);
            }
        }
        for(int i = 0;i<m;i++){
            if(board[0][i] == 'O'){
                dfs(0,i,visited,board,n,m);
            }
        }
        for(int i = 0;i<m;i++){
            if(board[n-1][i] == 'O'){
                dfs(n-1,i,visited,board,n,m);
            }
        }
        for(int i = 0;i<n;i++){
            if(board[i][m-1] == 'O'){
                dfs(i,m-1,visited,board,n,m);
            }
        }

        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(visited[i][j] ==0 && board[i][j] != 'X'){
                    board[i][j] = 'X';
                }
            }
        }                      


    }

    public void dfs(int row , int col , int[][] visited , char[][] board,int n ,int m){
        visited[row][col] = 1;

        int[] dx = {-1,0,1,0};
        int [] dy = {0,-1,0,1} ;

        for(int  i = 0;i<4;i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if(nrow>=0 && ncol>=0 && nrow< n && ncol <m && visited[nrow][ncol]==0 && board[nrow][ncol] =='O'){
              
                dfs(nrow, ncol, visited, board,n,m);
            }
        }

    }
}   