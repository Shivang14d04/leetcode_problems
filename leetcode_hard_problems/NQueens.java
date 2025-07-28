
import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, result, n, board);
        return result;

    }

    public void helper(int row, List<List<String>> result, int n, char[][] board) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (Safe(row, col, board, n)) {
                board[row][col] = 'Q';
                helper(row + 1, result, n, board);
                board[row][col] = '.';
            }
        }

    }

    public boolean Safe(int row, int col, char[][] board, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }

    public List<String> constructBoard(char[][] board) {
        List<String> current = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            current.add(new String(board[i]));
        }
        return current;
    }

}
