class Solution {
    public boolean canJump(int[] nums) {
        int last_index = nums.length-1;
        for(int i = nums.length-2;i>=0;i--){
            if(i+nums[i]>=last_index){
                last_index =i;
            }
        }
        if(last_index ==0){
            return true;
        }
        return false;
    }
}