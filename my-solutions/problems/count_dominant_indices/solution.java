class Solution {
    public int dominantIndices(int[] nums) {
      int count =0;
        int n = nums.length;
        for(int i =0;i<n-1;i++){
            int sum =0;
            for(int j = i+1;j<n;j++){
                sum += nums[j];
                
            }
            int avg = sum /(n-i-1);
            if(nums[i]> avg){
                count++;
            }
        }
        return count;
    }
    
}