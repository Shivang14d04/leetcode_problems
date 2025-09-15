import java.util.*;
class NumberOfWaysToArriveAtDestination{
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], t = r[2];
            adj.get(u).add(new int[]{t, v});
            adj.get(v).add(new int[]{t, u});
        }

        final long INF = Long.MAX_VALUE/4 ;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        long[] count = new long[n];
        count[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0L, 0L}); 

        final int MOD = (int)1e9 + 7;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int node = (int) cur[1];

            if (d > dist[node]) continue; // outdated entry

            for (int[] it : adj.get(node)) {
                int timeTaken = it[0];
                int nxt = it[1];
                long nd = d + (long) timeTaken;

                if (nd < dist[nxt]) {
                    dist[nxt] = nd;
                    count[nxt] = count[node];
                    pq.offer(new long[]{nd, nxt});
                } else if (nd == dist[nxt]) {
                    count[nxt] = (count[nxt] + count[node]) % MOD;
                }
            }
        }

        return (int) (count[n - 1] % MOD);
    }
}