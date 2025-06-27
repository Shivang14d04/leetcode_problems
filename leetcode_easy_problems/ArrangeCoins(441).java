class Solution {
    public int arrangeCoins(int n) {
     long s = 1;
     long e = n;
     int ans = 0;

    while(s<=e){

    long mid = s+(e-s)/2;
    long coinused = mid*(mid+1)/2;
    if(coinused == n ){
        return (int) mid;

    }
    else if(coinused> n){
        
        e = mid -1;
    }
    else{
        ans = (int) mid;
        s = mid+1;
    }

    }
    return ans;
       
    }
}