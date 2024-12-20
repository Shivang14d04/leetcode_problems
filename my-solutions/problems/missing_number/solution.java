class Solution {
    public int missingNumber(int[] nums) {
      Arrays.sort(nums);
      for(int i =0;i<nums.length;i++){
        if(nums[i] != i){
            return i;
        }

      } 
        if(nums[0]==0){
            return nums.length;
        }
        if(nums[0]==1){
            return 0;
        }      
      return -1; 
    }
}