import java.util.ArrayList;
class NumberOfOperationsToMakeNetworkConnected {
     public int makeConnected(int n, int[][] connections) {
        int countExtra=0;
        int connectedComp=0;

       DisjointSet ds = new  DisjointSet(n);
        for(int i = 0;i< connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUparent(u)== ds.findUparent(v)){
                countExtra++;
            }
            else{
                ds.UnionByRank(u,v);
            }
        }
        for(int i = 0;i<n;i++){
            if(ds.findUparent(i) == i){
                connectedComp ++;
            }
        }
        int ans = connectedComp -1;


        return (countExtra>=ans)?  ans: -1;
        
    }
}
class DisjointSet{
     ArrayList<Integer> rank = new ArrayList<>();
 ArrayList<Integer> parent = new ArrayList<>();
 
 public DisjointSet(int n ){
     for(int i =0;i<n;i++){
         rank.add(0); 
         parent.add(i);
        }
    }
 public int findUparent(int node){
     if(node == parent.get(node)){
         return node;
        }
     int ulp = findUparent(parent.get(node));
     parent.set(node, ulp);
     return parent.get(node);
    }
 public void UnionByRank(int u, int v){
     int ulp_u = findUparent(u);
     int ulp_v = findUparent(v);
     if(ulp_u == ulp_v) return;
     if(rank.get(ulp_u) < rank.get(ulp_v)){
         parent.set(ulp_u, ulp_v);
     }
     else if(rank.get(ulp_v)< rank.get(ulp_u)){
         parent.set(ulp_v, ulp_u);
        }
     else{
         parent.set(ulp_u, ulp_v);
         int rankU = rank.get(ulp_u);
         rank.set(ulp_u , rankU+1);
        }
    }
}