class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxPile = 0;
        for(int i = 0;i<n;i++){
            maxPile = Math.max(maxPile, piles[i]);
        }
        int s = 1;
        int e = maxPile;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            long totalHours = CalculateTotalHours( piles , mid);

            if(totalHours<=h){
                e = mid-1;
            }
            else{
                s =mid+1;
            }
        }
        return s;
    }

    public long CalculateTotalHours(int[] piles,int  speed){
        long hours = 0;
        for(int a : piles){
            hours+= (a+speed -1)/speed;
        }
        return hours;
    }
    
}