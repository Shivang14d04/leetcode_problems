class Solution {
    public int singleNonDuplicate(int[] nums) {
       int s = 0;
       int e = nums.length -1;
        if(nums.length==1) return nums[0];
        else{
            if(nums[0]!=nums[1]) return nums[0];
            if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
        }
       while(s<e){

        int mid = s +(e-s)/2;
        if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
            return nums[mid];
        }
        if(mid%2==0){
            if(nums[mid+1] == nums[mid]){
                s = mid +1;
            }
            else if(nums[mid-1] == nums[mid]){
                e = mid;
            }
        }
        else{
            if(mid%2!=0  && nums[mid+1] == nums[mid]){
                e = mid;
            }
            else if(mid %2!=0  && nums[mid-1] == nums[mid]){
                s = mid +1;
            }
            
        }
       } 
       return -1;
    }
}