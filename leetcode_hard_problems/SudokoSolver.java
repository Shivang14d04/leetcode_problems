
public class SudokoSolver {

    private static final int SIZE = 9;

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (backtrack(board)) {
                                return true;
                            }
                            board[i][j] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num
                    || board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
