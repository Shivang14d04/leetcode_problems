class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result  = new ArrayList<>();
        
        Subsets(ans , result , nums ,0);
        return result;
        
    }

    public void Subsets(List<Integer> ans , List<List<Integer>> result , int [] nums , int index){

        result.add(new ArrayList<>(ans));
        for( int i = index;i< nums.length;i++){
            ans.add(nums[i]);
            Subsets(ans , result , nums ,i+1);
            ans.remove(ans.size()-1);
            }
    }
}