class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Max(nums);
        int ans = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(CheckResultagainstThreshold(mid,nums,threshold)==true){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
        
    }

    public boolean CheckResultagainstThreshold(int divisor,int[]nums,int threshold){
        int sum = 0;
        for(int a : nums){
            sum += Math.ceil((double)a/divisor);
        }
        if(sum>threshold){
            return false;
        }
        return true;
    }

    public int Max(int[]nums){
        int ans = 0;
        for(int a:nums){
            ans = Math.max(ans,a);
        }
        return ans;
    }
}