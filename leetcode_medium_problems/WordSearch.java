
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (helper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        Boolean found = helper(board, word, index + 1, i + 1, j, visited)
                || helper(board, word, index + 1, i - 1, j, visited)
                || helper(board, word, index + 1, i, j + 1, visited)
                || helper(board, word, index + 1, i, j - 1, visited);

        visited[i][j] = false;
        return found;
    }
}
