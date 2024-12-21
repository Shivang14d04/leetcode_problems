class Solution {
    public int[] sortedSquares(int[] nums) {
       int [] ans = new int[nums.length];
       int k = 0;
       for(int i =0 ; i< nums.length;i++){
        ans[k] = nums[i]*nums[i];
        k++;
       }
       Arrays.sort(ans);
       return ans; 
    }
}