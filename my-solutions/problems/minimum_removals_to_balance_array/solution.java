class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0;
        int n = nums.length;
        int maxLen =1;
        for(int e = 0;e<n;e++){
            while(nums[e] > (long)k*nums[s]){
                s++;
            }
            maxLen = Math.max((e-s+1),maxLen);
        }
        return n - maxLen;
    }
}