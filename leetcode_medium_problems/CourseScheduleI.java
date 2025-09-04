import java.util.*;
class CourseScheduleI {
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for(int i =0;i< V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v= prerequisites[i][1];
            
            adj.get(u).add(v);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] inDegree  = new int[V];
        for(int i  =0;i<V;i++){
            for(int it: adj.get(i)){
                inDegree[it]++;
            }
        }
        int count =0;
        for(int i = 0;i<V;i++){
            if(inDegree[i]!=0){
                count++;
            }
        }
        if(count == V){
            return false;
        }
        
       ArrayList<Integer> ans = new ArrayList<>();
       
       for(int i =0;i<V;i++){
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
       return (ans.size() == V) ? true: false;

    }
}