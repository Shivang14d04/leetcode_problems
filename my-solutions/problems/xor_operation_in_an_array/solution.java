class Solution {
    public int xorOperation(int n, int start) {
        int [] nums = new int[n];
        for(int i =0 ;i < n;i++){
            nums[i] = start + 2 * i;
        }
        int result = nums[0];

        for(int j  =1; j < nums.length ;j++){
            result ^=nums[j];
        }
        return result;
        
    }
}