import java.util.*;
class ShortestPathInBinaryMatrix {
      public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], (int) 1e9);
        }

        dis[0][0] = 0;
        q.offer(new int[] { 0, 0, 0 });

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int length = arr[2];
            int x = arr[0];
            int y = arr[1];
            if(x== n-1 && y==n-1) return dis[x][y]+1;
            int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
            int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
            for (int i = 0; i < 8; i++) {
                int xrow = x + dx[i];
                int ycol = y + dy[i];

                if(xrow>=0&&ycol <n&& xrow<n&& ycol>=0 && grid[xrow][ycol]==0 && dis[xrow][ycol] > length+1){
                    dis[xrow][ycol] = length+1;
                    q.offer(new int[]{xrow,ycol,length+1});
                }

            }

        }
        return -1;

    }
}