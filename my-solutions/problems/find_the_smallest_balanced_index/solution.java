class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long [] sum = new long[n];
        double [] product = new double[n];
        for(int i = 0;i<n;i++){
            if(i==0){
                sum[i] = 0;
                product[n-i-1] = 1;
            }
            else{
            sum[i] = sum[i-1]+ nums[i-1];
                    
            
            product[n-i-1] = product[n-i]*nums[n-i];
            }

        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if((double)sum[i] == product[i]) {
                ans = Math.min(ans,i);
            }
        }
        return ans== Integer.MAX_VALUE ? -1 : ans;
    }
}