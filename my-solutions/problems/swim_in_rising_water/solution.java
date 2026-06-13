class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean [][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});


        while(!pq.isEmpty()){
            int [] temp  = pq.poll();
            int h = temp[0];
            int row = temp[1];
            int col = temp[2];
            if(row == n-1 && col == n-1) return h;
            vis[row][col] = true;
            int [] dx = {-1,0,1,0};
            int [] dy = {0,-1,0,1};
            for(int i =0;i<4;i++){
                int r = row + dx[i];
                int c = col + dy[i];
                if(r>=0 && c >=0 && r< n&& c<n && !vis[r][c] ){
                    pq.offer(new int[]{Math.max(h,grid[r][c]),r,c});
                }
            }
        }
        return -1;
    }
}