class Solution {
    public boolean checkGoodInteger(int n) {
        int sum = 0;
        int sq = 0;
        while(n>0){
            int r = n%10;
            n = n/10;
            sum += r;
            sq +=  r*r;
        }
        if(sq-sum>=50){
            return true;
        }
        return false;
    }
}