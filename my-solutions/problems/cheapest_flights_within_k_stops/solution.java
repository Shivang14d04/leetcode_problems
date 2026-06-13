class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] a: flights){
            int u = a[0];
            int v = a[1];
            int wt = a[2];
            adj.get(u).add(new int[]{v,wt});
        }
        int [] dis = new int[n];
        Arrays.fill(dis, (int)1e9);
        dis[src]=0;
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{src,0,0});

        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int d = pq.peek()[1];
            int stops = pq.peek()[2];
            pq.remove();
            if(stops > k ) continue;
            for(int[] it: adj.get(node)){
                int next = it[0];
                int w = it[1];
                if(d + w < dis[next] && stops<=k){
                    dis[next] = d + w;
                    pq.offer(new int[]{next,dis[next], stops+1});
                }
            }
        }
        return dis[dst]== (int)1e9 ? -1:dis[dst];
    }
}