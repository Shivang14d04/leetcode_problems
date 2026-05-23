class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,list,ans);
        return ans;
    }
    public void helper(int [] nums,List<Integer> list,List<List<Integer>> ans){
        if(list.size()== nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            helper(nums,list,ans);
            list.remove(list.size()-1);
        }
    }
}