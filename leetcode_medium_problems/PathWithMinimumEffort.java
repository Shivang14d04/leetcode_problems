import java.util.*;
class Solution{
      public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m= heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});
        int [][] dis = new int[n][m];
        for(int i = 0;i<n;i++){
        Arrays.fill(dis[i],(int)1e9);

        }
        dis[0][0] = 0;
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int diff = arr[0];
            int row = arr[1];
            int col = arr[2];
            if(row == n-1 && col == m-1) return diff;

            int[] dx = {-1,0,1,0};
            int [] dy = {0,-1,0,1};
            for(int i = 0;i<4;i++){
                int x = row + dx[i];
                int y = col + dy[i];

                if(x>=0 && y>=0 && x<n && y<m ){
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[x][y]),diff);
                    if(newEffort <dis[x][y]){
                        dis[x][y] = newEffort;
                        pq.offer(new int[]{newEffort,x,y});
                    }
                }
            }
        }
        return 0;
        
    }
}