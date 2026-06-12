class Solution {
  private  HashSet<Integer> set;
  private int cycleStart;

    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = edges.length;
        set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n+1];
        cycleStart =-1;
        dfs(-1,1,adj,vis);
        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (set.contains(u) && set.contains(v)) {
                return new int[]{u, v};
            }
        }
        return new int[0];

    }

    public boolean dfs(int parent, int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        if (vis[node]) {
            cycleStart = node;
            return true;
        }

        vis[node] = true;
        for (int it : adj.get(node)) {
            if (it == parent)
                continue;
            if (dfs(node, it, adj, vis)) {
                if (cycleStart != -1)
                    set.add(node);
                if (node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}