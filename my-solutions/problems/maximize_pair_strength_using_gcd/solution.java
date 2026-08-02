class Solution {
    public long maxPairStrength(int[] nums) {
        long max  = 0;
        int n = nums.length;
        
        for(int i=0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int gcd = findGcd(nums[i],nums[j]);
                 max = (long) Math.max(max, ((long)nums[i]*nums[j])/((long)gcd*gcd));
            }
        }
        return max;
    }
    public int findGcd(int a , int b){
        if(b==0)return a;
        return findGcd(b,a%b);
    }
}