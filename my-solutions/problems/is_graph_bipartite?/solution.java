class Solution {
    public boolean isBipartite(int[][] graph) {
        int  n = graph.length;
        int [] color = new int[n];
        Arrays.fill(color,-1);

        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(!dfs(i,0,graph,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int c , int [][] graph, int[] color){
        color[node] = c;
        for(int neigh: graph[node]){
            if(color[neigh] ==-1){
                if(!dfs(neigh,1-c,graph,color)){
                    return false;
                }
            }
            else if(color[neigh]== color[node]){
                return false;
            }
        }
        return true;
    }
}