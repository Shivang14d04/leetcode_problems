class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        if(n==0)return 0;
        if(n==1)return nums[0];

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0) temp1.add(nums[i]);
            if(i!=n-1)temp2.add(nums[i]);
        }
        return Math.max(helper(temp1), helper(temp2));
        

    }
    public int helper(ArrayList<Integer> nums){
        int prev1= nums.get(0), prev2 = 0;
        int n  = nums.size();
        for(int i=1;i<n;i++){
            int curr = Math.max((nums.get(i)+ prev2), prev1);
            prev2 = prev1;
            prev1 = curr;

        }
        return prev1;
    }
}