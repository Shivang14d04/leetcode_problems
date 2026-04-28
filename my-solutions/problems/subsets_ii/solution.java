class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Set<List<Integer>> set = new HashSet<>();
       List<Integer> curr = new ArrayList<>();
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);
       helper(set,curr,nums,0); 
       for(List<Integer> a: set ){
        ans.add(a);
       }
       return ans;
    }
    public void helper(Set<List<Integer>> set,List<Integer> curr, int[] nums, int index){
        if(index >= nums.length){
            set.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        helper(set,curr,nums,index+1);
        curr.remove(curr.size()-1);
        helper(set,curr,nums,index+1);

    }
}