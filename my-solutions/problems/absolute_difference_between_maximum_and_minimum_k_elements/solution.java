class Solution {
    public int absDifference(int[] nums, int k) {
       Arrays.sort(nums);
        int n = nums.length;
        int minSum = 0;
        int maxSum = 0;
        for(int i = 0;i<k;i++){
            minSum+= nums[i];
        }
        for(int i = n-1;i>=0;i--){
            if(k==0)break;
            maxSum += nums[i];
            k--;
        }
        return maxSum - minSum;
    }
}