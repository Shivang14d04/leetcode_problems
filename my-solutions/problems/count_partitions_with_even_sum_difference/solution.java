class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        int leftSum = 0;
        int count = 0;
        int n = nums.length;
        
            for(int j = 0;j<n-1;j++){
                leftSum+= nums[j];
                if(((sum-leftSum) -leftSum)%2==0){
                    count++;
                    
                }
            }
        return count;
    }
}