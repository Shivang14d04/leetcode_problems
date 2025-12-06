class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int s  =0;
        int e = nums.length-1;
        ans[0] = FirstIndex(s,e,target,nums);
        ans[1] = LastIndex(s,e,target,nums);

return ans;

    }
    public int LastIndex(int s , int e , int target, int[] nums){
        int temp = -1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(nums[mid]==target){
                temp = mid;
                s = mid+1;

            }
            else if(nums[mid]>target){
                e = mid -1;
            }
            else{
                s = mid +1;
            }
        }
        return temp;
       
    }
        public int FirstIndex(int s , int e , int target, int[] nums){
        int temp = -1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(nums[mid]==target){
                temp = mid;
                e = mid-1;

            }
            else if(nums[mid]>target){
                e = mid -1;
            }
            else{
                s = mid +1;
            }
        }
        return temp;
       
    }
}