import java.util.*;
class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];

        for(int i = 0;i<n;i++){
            for(int it: graph[i]){
                adj.get(it).add(i);
                inDegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();

        for(int i =0;i<n;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            ans.add(node);

            for(int it: adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}