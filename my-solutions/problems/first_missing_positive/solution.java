class Solution {
    public int firstMissingPositive(int[] nums) {
       int n = nums.length;
       for(int i =0;i<n;i++){
        if(nums[i]<=0 || nums[i]>n){
            continue;
        }

        int index = nums[i]-1;
        if(nums[i] != nums[index]){
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            i--;
        }

       } 

       for(int i =0;i<n;i++){
        if(nums[i] != i+1){
            return i+1;
        }
       }
       return n+1;
    }
}