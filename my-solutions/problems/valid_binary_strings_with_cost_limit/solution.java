class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(0,n,k,0,false,sb,ans);
        return ans;
    }
    public void helper(int index, int n , int k , int c, boolean prev,StringBuilder sb, List<String> ans){
        if(c>k)return;
        if(index==n){
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        helper(index+1,n,k,c,false,sb,ans);
        sb.deleteCharAt(sb.length()-1);
        if(!prev){
            sb.append('1');
            helper(index+1,n,k,c+index,true,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}