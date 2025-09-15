import java.util.*;
class NetworkDelayTime{
     public int networkDelayTime(int[][] times, int n, int k) {
        int l = times.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<l;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u-1).add(new int[]{v-1,time});
        }
        int [] dis = new int[n];
        Arrays.fill(dis,(int)1e9);
        dis[k-1] =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k-1});
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[1];
            int weight = arr[0];

            for(int[] it: adj.get(node)){
                int nextNode = it[0];
                int timeTaken = it[1];
                if(dis[nextNode] >weight + timeTaken){
                    dis[nextNode] = weight+ timeTaken;
                    pq.offer(new int[]{dis[nextNode],nextNode});
                }
            }

        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(dis[i]==(int)1e9) return -1;
            ans = Math.max(dis[i],ans);
        }
        return ans;
        
    }
}