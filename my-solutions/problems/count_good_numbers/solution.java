class Solution {
    int mod = 1_000_000_007;
    public int countGoodNumbers(long n) {

        if(n==1)return 5;
        if(n==2) return 20;
     long even = n/2;
     long odd = n -even ;

     long a = helper(even , 4);
     long b = helper(odd ,5);
     return (int) ((a*b)%mod);
    }


    public long helper(long n , long y){
        long result =1;
        y = y%mod;
        
        while(n >0){
            if(n%2 ==1){
                result = (result*y)%mod;
            }
            y=(y*y)%mod;
            n =  (n/2);
        }
        return result;
    }
}