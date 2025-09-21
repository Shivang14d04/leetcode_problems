class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0], 0 ,0});
        visited[0][0] = true;
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int elevation = arr[0];
            int row = arr[1];
            int col = arr[2];
            int[] dx  = {-1,0,1,0};
            int [] dy = {0,-1,0,1};
            if(row==n-1 && col == n-1) return elevation;
            for(int i = 0;i<4;i++){
                int newR = row + dx[i];
                int newC = col + dy[i];
                if(newR>=0 && newC>=0 && newR< n && newC < n && !visited[newR][newC]){
                    visited[newR][newC] =true;
                    pq.offer(new int[]{Math.max(elevation, grid[newR][newC]) , newR, newC});
                }
            }
        }
        return -1;
        
    }
}