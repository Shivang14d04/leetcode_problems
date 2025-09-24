class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans =  new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int val =  nums[i];
            int rem = target - val;
            if(map.containsKey(rem)){
                ans[0]  = map.get(rem);
                ans[1] = i;
            }
            map.put(nums[i],i);
        }
return ans;
        
    }
}