class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans  = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int [] lowerDiagonal = new int[2*n-1];
        helper(0,ans,board,n,leftRow,upperDiagonal,lowerDiagonal);
        return ans;
    }
    public void helper(int col,List<List<String>> ans, char[][]board, int n,int[] leftRow, int[] upperDiagonal,int []lowerDiagonal ){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i =0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int row =0;row<n;row++){
            if(leftRow[row]==0 && lowerDiagonal[col+row]==0 && upperDiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                leftRow[row]=1;
                lowerDiagonal[col+row]=1 ;
                upperDiagonal[n-1+col-row]=1;
                helper(col+1,ans,board,n,leftRow,upperDiagonal,lowerDiagonal);
                board[row][col] ='.';
                leftRow[row]=0;
                lowerDiagonal[col+row]=0 ;
                upperDiagonal[n-1+col-row]=0;                
            }
        }
    }

}