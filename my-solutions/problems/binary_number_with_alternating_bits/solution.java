class Solution {
    public boolean hasAlternatingBits(int n) {
        int prevr = -1;
        while(n>0){
            int r = n% 2;
            if(prevr == r ){
                return false;
            }

             prevr = r;
            n /=2;
        }
        return true;
        
    }
}