
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (solution("", board, word, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean solution(String p, char[][] board, String word, int i, int j, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(0) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        word = word.substring(1);

        boolean found = solution(p + board[i][j], board, word, i + 1, j, visited)
                || solution(p + board[i][j], board, word, i, j + 1, visited)
                || solution(p + board[i][j], board, word, i - 1, j, visited)
                || solution(p + board[i][j], board, word, i, j - 1, visited);

        visited[i][j] = false;
        return found;

    }

}
