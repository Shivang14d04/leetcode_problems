class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int s = 1;
       int ans =1;
       int n = piles.length;
       int e = 0;
       for(int pile : piles){
        e = Math.max(pile,e);
       }

       while(s<=e){
        int mid = s + (e - s)/2;
        if(findK(mid,piles,h)){
            ans = mid;
            e = mid-1;
        }
        else{
            s = mid+1;
        }
       }
       return ans;
    }

    public boolean findK(int k, int[]nums , int h){
        for(int i = 0;i<nums.length;i++){
            h -= (nums[i]+k-1)/k;
        }
        if(h>=0)return true;
        else return false;
    }
}