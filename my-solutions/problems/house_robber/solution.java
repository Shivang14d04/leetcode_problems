class Solution {
    public int rob(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;
       
       

        for(int i = 1 ;i<nums.length;i++){
            int pick = nums[i];
            if(i>1){
                 pick = pick + prev2;
            }

            int skip = prev;
           int current = Math.max(pick,skip);
           prev2 = prev;
           prev = current;


        }
        return prev;
        
    }
}