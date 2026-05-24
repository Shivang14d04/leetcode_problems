class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        helper(ans,0,0,sb,n); 
        return ans;       

    }
    public void helper(List<String> ans, int open, int closed, StringBuilder s, int n ){
        if(open == n && open == closed){
            ans.add(s.toString());
            return;
        }

        if(open<n){
            s.append("(");
            helper(ans,open+1,closed,s,n);
            s.deleteCharAt(s.length()-1);
        }
        
        if(closed<open){
            s.append(")");
            helper(ans,open,closed+1,s,n);
            s.deleteCharAt(s.length()-1);
        }
    }

}