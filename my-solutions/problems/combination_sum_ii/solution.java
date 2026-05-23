class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list  = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(0,list,ans,candidates,target);
        return ans;

    }
    public void helper(int index, List<Integer> list, List<List<Integer>> ans, int[] candidates , int target){

        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<candidates.length;i++){
            if(i> index && candidates[i]== candidates[i-1])continue;
            if(candidates[i]>target)break;
            list.add(candidates[i]);
            helper(i+1,list,ans,candidates,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }

}