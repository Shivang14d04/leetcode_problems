class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0;i< nums.length;i++){
            totalSum += nums[i];
        }

        if(totalSum%2 !=0){
            return false;
        }
        else{
            int n = nums.length;
            int k = totalSum/2;
            boolean [] prev = new boolean[k+1];
            prev[0] = true;

            if(nums[0]<=k){
                prev[nums[0]] = true;
            }

            for(int i = 1;i<nums.length;i++){
                boolean[] curr = new boolean[k+1];
                curr[0] = true;
                for(int j = 1;j<=k;j++){
                    boolean notTake = prev[j];
                    boolean take = false;
                    if(nums[i]<=j){
                        take = prev[j-nums[i]];
                    }

                    curr[j] = take || notTake;
                }
                prev = curr;
            }
            return prev[k];

            }
    }


}