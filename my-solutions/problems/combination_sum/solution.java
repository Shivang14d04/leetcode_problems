class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates , target , ans , result , 0 ,0);
        return result;

        
    }

    public void helper(int [] arr ,int target ,List<Integer> ans , List<List<Integer>> result  ,int sum , int index){
        if(sum == target){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(sum>target){
            return;
        }

        for(int i  = index;i<arr.length;i++){
            ans.add(arr[i]);
            helper(arr , target , ans , result , sum + arr[i] ,i);
            ans.remove(ans.size() -1);
        }
    }
}