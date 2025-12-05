class Solution {
    public double myPow(double x, int n) {
        long p = n;
 
         
        if(p<0){
                 return 1/power(x,-p);
            
            
        }
        return  power(x,p);
        
    }
    public double power(double x, long n){
        if(n==0) return 1;
        if(n==1) return x;
        if(n%2==0){
            return power(x*x , n/2);
        }
        return x* power(x,n-1);
    }
}