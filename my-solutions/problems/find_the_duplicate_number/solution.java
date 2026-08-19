class Solution {
    public int findDuplicate(int[] nums) {
        int i =0;
        while(i<nums.length){
            int correctIndex = nums[i] -1;
            if(nums[i]!=nums[correctIndex]){
                int temp =  nums[i];
                nums[i]  = nums[correctIndex];
                nums[correctIndex] = temp;
            }
            else if(i!= correctIndex && nums[i]==nums[correctIndex]){
                return nums[i];
            }
            else{
                i++;
            }
        }
        return -1;

    }
}