class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n  = nums.length;
        int odd = 0, even = 0,count=0;
        
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                if(nums[j]%2==0)even++;
                else{
                    odd++;
                }
                double ratio = (double)even/odd;
                double numberRatio = (double)a/b;
                if(odd >0 && ratio <= numberRatio){
                    count++;
                }
            }
            even = 0;
            odd  = 0;
        }
        return count;
    }
}