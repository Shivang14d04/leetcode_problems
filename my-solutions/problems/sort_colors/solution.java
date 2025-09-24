class Solution {
    public void sortColors(int[] nums) {
        int n  = nums.length;
        int s = 0 , m = 0, e = n-1;
        while(m<=e){
            if(nums[m] ==0){
                int temp = nums[s];
                nums[s] = nums[m];
                nums[m] = temp;
                s++;
                m++;
                
            }
            else if(nums[m]==1){
                m++;
            }
            else{
                int temp = nums[m];
                nums[m] = nums[e];
                nums[e] = temp;
                e--;
                                
            }
        }
        
    }
}