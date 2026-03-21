class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int n = nums.length;
       long currSum = 0;
       long maxSum = 0;
       int begin =0;
       Set<Integer> set = new HashSet<>();
       for(int end = 0;end < n;end++){
        if(!set.contains(nums[end])){
            currSum += nums[end];
            set.add(nums[end]);
            if(end-begin +1 ==k){
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[begin];
                set.remove(nums[begin]);
                begin++;
            }
        }
        else{
            while(nums[begin]!=nums[end]){
                currSum -= nums[begin];
                set.remove(nums[begin]);
                begin++;
            }
            begin++;
        }
       } 
       return maxSum;
    }
}