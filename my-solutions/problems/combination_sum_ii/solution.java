class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        helper(result, comb,candidates,target, 0);
        return result;
    }
    public void helper(List<List<Integer>> result,List<Integer> comb, int [] nums, int target, int index ){
        if(target== 0){
             result.add(new ArrayList<>(comb));
            return;
        }
        if(target < 0 || index > nums.length-1){
            return;
        }

        comb.add(nums[index]);

        helper(result,comb,nums,target-nums[index], index+1);
        comb.remove(comb.size()-1);
                while(index+1 < nums.length && nums[index+1] == nums[index]){
            index++;
        }
        helper(result,comb,nums,target,index+1);
    }
}