class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> comb  = new ArrayList<>();
        dfs(result, comb, 0 , candidates, target);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> comb , int index, int [] nums, int target){
        if(target == 0){
            result.add(new ArrayList<>(comb));
            return;
        }

        if(target <0 || index > nums.length -1){
            return;
        }
        comb.add(nums[index]);
        dfs(result,comb,index,nums,target - nums[index]);
        comb.remove(comb.size()-1);
        dfs(result,comb,index+1,nums ,target);
    }
}