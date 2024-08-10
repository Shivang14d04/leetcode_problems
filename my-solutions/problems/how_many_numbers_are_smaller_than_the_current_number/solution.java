class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
    int [] arr = new int [nums.length];
        for(int i = 0;i<nums.length;i++){
                    int count  = 0;
            int max = nums[i];
            for(int j=0;j<nums.length;j++){

                if(nums[j] < max){
                count++;
                }
            }
            arr[i] = count;
        }
        return arr;
    }
}