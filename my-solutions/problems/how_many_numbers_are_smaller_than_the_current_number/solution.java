class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = 0;
        int count =0;
    int [] ans = new int[nums.length];
    for(int i =0;i<nums.length;i++){
        max = nums[i];
        for(int j =0;j<nums.length;j++){
            if(max > nums[j]){
                count+=1;
            }

        }
        ans[i] = count;
        count = 0;
    }  
    return ans;  
    }
}