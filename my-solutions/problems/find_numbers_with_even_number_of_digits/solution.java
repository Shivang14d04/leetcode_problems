class Solution {
    public int findNumbers(int[] nums) {
        int output = 0;
        int count = 0;
        int r;
        for(int i = 0;i<nums.length;i++){
            while(nums[i] !=0){
                r = nums[i]%10;
                nums[i] = nums[i]/10;
                count++;
            }
            if(count%2==0){
            output++;
            }
            count = 0;
        }
        return output;
    }
}