class Solution {
    public int rob(int[] nums) {
        int prev1= nums[0], prev2 = 0;
        int n  = nums.length;
        for(int i=1;i<n;i++){
            int curr = Math.max((nums[i]+ prev2), prev1);
            prev2 = prev1;
            prev1 = curr;

        }
        return prev1;
        

    }

}