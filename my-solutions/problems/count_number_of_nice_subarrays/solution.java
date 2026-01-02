class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);

    }
    public int helper(int[] nums, int k){
        int right=0;
        int n = nums.length;
        int left =0;
        int count = 0;
        int ans  =0;
        while(right<n){
            if(nums[right]%2!=0){
                count++;
            }
            while(count>k){
                if(nums[left]%2!=0){
                    count--;
                }
                left +=1;

            }
            ans += right-left+1;
            right++;
        }
        return ans;

    }
}