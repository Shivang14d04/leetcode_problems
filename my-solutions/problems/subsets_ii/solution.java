class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>>  ans = new ArrayList<>();
        helper(0,list,nums,ans);
        return ans;

    }
    public void helper(int ind,List<Integer> list , int[] nums, List<List<Integer>>  ans){
                ans.add(new ArrayList<>(list));
                
            
            for(int i = ind;i<nums.length;i++){
                if(i>ind && nums[i]==nums[i-1])continue;
                list.add(nums[i]);
                helper(i+1,list, nums,ans);
                list.remove(list.size()-1);
            }

    }
}