class Solution {
    public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> sub = new ArrayList<>();
      helper(sub, ans, 0, nums);
      return ans;  
    }
    public void helper(  List<Integer> sub, List<List<Integer>> ans, int index, int [] nums){
        if(index > nums.length-1){
            ans.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        helper(sub,ans,index+1,nums);
        sub.remove(sub.size()-1);
        helper(sub,ans,index+1,nums);
    }
}