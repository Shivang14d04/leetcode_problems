class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int ans = 0;
        int a = Math.max(1,n-k);
        for(int i = a;i<= n+k;i++){
            if((n&i)==0) ans += i;
        }
        return ans;
    }
}