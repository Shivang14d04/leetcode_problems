class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max = 0;
       for(int i =0;i<piles.length;i++){
        max = Math.max(piles[i],max);
       } 
       int start  = 1, end = max;
       int ans = 0;
       while(start<=end){
        int mid = start +(end-start)/2;
        if(canEat(mid,h,piles)){
            ans = mid;
            end = mid -1;
        }
        else if( !canEat(mid,h,piles)){
            start = mid +1;
        }
       }
       return ans;
    }

    public boolean canEat(int k, int h, int []piles){
        long time= 0;
        for(int i =0;i<piles.length;i++){
            time += ((long) piles[i] + k - 1) / k; 
                        if(time > h)return false;

        }
        return true;

    }
}