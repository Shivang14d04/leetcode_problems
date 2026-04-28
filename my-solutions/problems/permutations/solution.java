class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] mark = new boolean[n];
        helper(ans,curr,mark,nums);
        return ans;
    }
    public void helper(List<List<Integer>>  ans,List<Integer> curr,boolean[] mark, int [] nums){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }

        for(int i = 0;i<nums.length;i++){
            if(mark[i]) continue;
            curr.add(nums[i]);
            mark[i] = true;
            helper(ans,curr,mark,nums);

            curr.remove(curr.size()-1);
            mark[i]=false;
        }
    }
}