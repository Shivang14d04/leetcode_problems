class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
       int n = capacity.length;
        int ans = -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(capacity[i]>= itemSize && capacity[i] < min) {

                min = Math.min(capacity[i],min);
                ans = i;
                    
                
            }
        }
        return ans;
    }
}