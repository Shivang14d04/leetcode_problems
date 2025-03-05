class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        return binarySearch(start , end  , target , nums);

        
    }
    public static int binarySearch(int start , int end , int target , int [] nums){
        if(start>end) return -1;
        int mid = start +(end-start)/2;

        if(nums[mid]== target) return mid;
        else if(nums[mid]>target){
           return binarySearch(start , mid -1 , target , nums);
        }
        else{
            return binarySearch(mid+1 ,  end , target , nums);

        }
        
    }
}