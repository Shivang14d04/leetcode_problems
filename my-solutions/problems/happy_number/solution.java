class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        while(slow!=fast);
        if(slow==1)
        {
            return true;
        }
        return false;
    }
    private int squareSum(int n ){
        int ans =0;
        while(n>0){
            int rem = n%10;
            ans += rem*rem;
            n/=10;
        }
        return ans;
    }
}