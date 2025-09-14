import java.util.*;
class CheapestFlightWithInKstops {
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int weight = flights[i][2];
            adj.get(u).add(new int[]{v,weight});
        }

        int[] dis = new int[n];
        Arrays.fill(dis,(int)1e9);
        dis[src] =0;
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0,src,0});
        while(!pq.isEmpty()){
            int [] arr = pq.poll();
            int distance = arr[2];
            int node = arr[1];
            int stops = arr[0];
           
            if(stops>k) continue;
            for(int[] it: adj.get(node)){
                int edgeWeight = it[1];
                int nextNode = it[0];
            
            if(dis[nextNode] > distance + edgeWeight &&  stops<=k ){
                dis[nextNode] = distance+edgeWeight;
                pq.add(new int[]{stops+1,nextNode, dis[nextNode]});
            }
            }


        }
        if(dis[dst]== (int)1e9) return -1;
        return dis[dst];

    }
}