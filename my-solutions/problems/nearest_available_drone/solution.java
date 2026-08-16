class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;
        int min = Integer.MAX_VALUE, index = -1;
        for(int i =0;i<n;i++){
            int x1 = drones[i][0];
            int y1 = drones[i][1];
            int dis = Math.abs(x1-target[0])+ Math.abs(y1-target[1]);
            if(dis <= drones[i][2]){
                if(dis<min){
                    min = dis;
                                   index = i;
 
                }
            }
        }
        return index;
    }
}