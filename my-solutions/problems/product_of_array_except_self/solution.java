class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int n  = nums.length;
        int count =0;

        for(int i = 0;i<n;i++){
            if(nums[i] == 0)count++;
            else{
            prod *= nums[i];

            }
        }

        if(count ==0){
            for(int i =0;i<n;i++){
                nums[i] = prod/nums[i];
            }
        }
        else if(count ==1){
            for(int i =0;i<n;i++){
                if(nums[i]!=0){
                    nums[i]=0;
                }
                else{
                    nums[i] = prod;
                }
            }
        }
        else{
            for(int i =0;i<n;i++){
                nums[i]=0;
            }
        }
        return nums;
    }
}