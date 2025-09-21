import java.util.*;
class CriticalConnectionsInAnetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i< connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] vis = new int[n];
        int[] tin = new int [n];
        int[] low = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,-1,adj,vis, tin, low,ans);
        return ans;
    }

    public int timer = 1;

    public void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] tin,
            int[] low, List<List<Integer>> ans) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        for(int it: adj.get(node)){
            if(it== parent) continue;
            if(vis[it]==0){
                dfs(it,node,adj,vis,tin,low,ans);
               low[node] = Math.min(low[node], low[it]);
               if(low[it]> tin[node]){
                ans.add(Arrays.asList(it,node));
               }
            }
            else{
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }
}