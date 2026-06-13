class Solution {
    public int minCostConnectPoints(int[][] points) {
        int  n  = points.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            int x1 = points[i][0];
            int y1 =points[i][1];
            for(int j = i+1;j<n;j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int wt = Math.abs(x1-x2)+ Math.abs(y1-y2);
                adj.get(i).add(new int[]{j,wt});
                adj.get(j).add(new int[]{i,wt});
            }
        }

        int [] vis = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.offer(new int[]{0,0});
        int cost =0;
        while(!pq.isEmpty()){
            int node =pq.peek()[0];
            int w = pq.peek()[1];
            pq.remove();
            if(vis[node]==1)continue;
            cost += w;
            vis[node] = 1;
            for(int [] it: adj.get(node)){
                int next = it[0];
                int weight = it[1];

                if(vis[next]==0){
                    pq.offer(new int[]{next,weight});
                }
            }
        }
        return cost;
    }
}