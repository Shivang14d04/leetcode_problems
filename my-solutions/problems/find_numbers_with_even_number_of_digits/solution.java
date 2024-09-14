class Solution {
    public int findNumbers(int[] nums) {
       int count =0;
       int sum =0;
       int r;
       for(int i =0;i<nums.length;i++){
        while(nums[i] !=0){

            count ++;
            nums[i]  = nums[i]/10;
        }
        if(count%2==0){
            sum ++;
        }
        count =0;
       } 
       return sum;
    }
}