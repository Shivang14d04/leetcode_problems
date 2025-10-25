class Solution {
    public long subArrayRanges(int[] nums) {
        int n  = nums.length;
        long sum = 0;
        for(int i = 0;i<n;i++){
            int smallest = nums[i];
            int largest = nums[i];
            for(int j = i+1;j<n;j++){
                smallest = Math.min(nums[j],smallest);
                largest = Math.max(nums[j], largest);
                sum += (largest - smallest);
            }
        }
        return sum;
    }
}