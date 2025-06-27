class Solution {
    public boolean isPerfectSquare(int num) {
     long s = 0;
     long e = num;
     if(num==0||num==1){
        return true;
     }
     while(s<=e){
        long mid = s+(e-s)/2;
        long square = mid*mid;
        if(square == num){
            return true;
        }
        else if(square<num){
            s = mid+1;
        }
        else{
            e = mid -1;
        }
     }
     return false;

    }
}