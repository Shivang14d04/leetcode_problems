class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new int[] { v, w });

        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { k, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];
            if (weight > dis[node])
                continue;
            for (int[] a : adj.get(node)) {
                int next = a[0];
                int wt = a[1];
                if (dis[node] + wt < dis[next]) {
                    dis[next] = dis[node] + wt;
                    pq.add(new int[] { next, dis[next] });
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dis[i]);
        }

        return ans;
    }
}