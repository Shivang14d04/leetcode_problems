class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,nums,list,ans);
        return ans;
    }
    public void helper(int index, int [] nums, List<Integer> list , List<List<Integer>> ans){
        if(index > nums.length -1){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        helper(index+1,nums,list,ans);
        list.remove(list.size()-1);
        helper(index+1, nums,list,ans);
    }
}