class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i = 0;i<n;i++){
            int s = i+1;
            int e = n-1;
            while(s<e){
                int sum = nums[i] + nums[s] + nums[e];
                if(sum<target){
                    s++;
                }
                else{
                    e--;
                }
                if(Math.abs(target-sum) < Math.abs(target-ans)){
                    ans = sum;
                }
            }
        }
        return ans;
    }
}