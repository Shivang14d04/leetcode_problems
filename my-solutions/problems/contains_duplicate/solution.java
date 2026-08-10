class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            set.add(nums[i]);
        }
        return set.size()==n ? false :true;
    }
}