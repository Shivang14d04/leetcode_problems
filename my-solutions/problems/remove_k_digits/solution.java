class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        int  n = num.length();
        if(n== k) return "0";
        for(int i  = 0;i<n;i++){
            char ch = num.charAt(i);
            while(!st.isEmpty()&& k>0 && st.peek() - '0'>ch -'0'){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty())return "0";
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        while(ans.length() != 0 && ans.charAt(ans.length()-1)=='0'){
            ans.deleteCharAt(ans.length() -1);
        }
        ans.reverse();
        if(ans.length()==0)return "0";
        return ans.toString();

    }
}