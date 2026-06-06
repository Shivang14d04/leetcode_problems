class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);
        for (int i = 0; i < v; i++) {
            if(color[i]==-1){
                color[i]=0;
            if (!dfs(i, color, graph)) {
                return false;

            }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[] color, int[][] graph) {
            for (int it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                if(!dfs(it,color,graph)){
                    return false;
                }
                }
                 if(color[it] == color[node]) {
                    return false;
                }
            }
        return true;
    }
}