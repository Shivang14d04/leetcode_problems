class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> ans = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
        helper(1,n,ans,temp,k);
        return ans;

    }
    public void helper(int start, int n,List<List<Integer>> ans,List<Integer> temp, int k){
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start;i<=n;i++){
            temp.add(i);
            helper(i+1,n,ans,temp,k);
            temp.remove(temp.size()-1);
        }
    }
}