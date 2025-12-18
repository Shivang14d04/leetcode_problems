class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int n =  nums.length;
        for(int a: nums){
            start = Math.max(start,a);
            end += a;
        }
        if(n==1) return nums[0];
        if(k>n) return -1;
        int ans = -1;
        while(start<=end){
            int mid = start + (end -start)/2;
            if(helper(nums,mid,k)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
        
    }
    public boolean helper(int[] nums, int d , int k){
        int sum  = 0;
        int subArray  =1;
        for(int i = 0;i<nums.length;i++){
            if(sum+nums[i]>d){
                subArray++;
                sum=nums[i];
                if(subArray>k){
                    return false;
                }
            }
            else{
                sum+=nums[i];
            }
          
        }
        return true;
    }
}