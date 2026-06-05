class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;
        int [][] vis = grid;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int time = 0;

        while (freshOranges>0 &&!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.remove();
                int[] dx = { -1, 0, 1, 0 };
                int[] dy = { 0, -1, 0, 1 };
                for (int i = 0; i < 4; i++) {
                    int row = r + dx[i];
                    int col = c + dy[i];

                    if (row > n - 1 || col > m - 1 || row < 0 || col < 0 ||vis[row][col] != 1) {
                        continue;
                    }
                    q.offer(new int[] { row, col });
                    vis[row][col] = 2;
                    freshOranges--;

                }
            }
            time++;


        }
        return freshOranges !=0 ? -1: time;
    }
}