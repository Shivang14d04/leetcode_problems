class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        boolean change = false;
        for(int i =0;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                continue;
            }
            if(change){
                return false;
            }
            if(i==0 || nums[i+1]>= nums[i-1]){
                nums[i]=nums[i+1];

            }
            else{
                nums[i+1]=nums[i];
            }
            change = true;
        }
        return true;
    }
}