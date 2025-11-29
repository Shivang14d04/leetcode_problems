class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int sum  = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        int count =0;
        while(sum>=0){
            if(sum%k ==0){
                return count;
            }
            else{
                sum--;
                count++;
            }
        }
        return -1;
    }
}