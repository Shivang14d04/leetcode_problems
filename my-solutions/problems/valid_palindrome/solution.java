class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
    if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) || (ch>= '0' && ch <= '9')) {
        sb.append(ch);
    }
        }
       String temp = sb.toString().toLowerCase();
       return helper(temp);
    }
    public boolean helper(String s){
        int i =0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}