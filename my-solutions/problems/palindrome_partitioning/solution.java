class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans  = new ArrayList<>();
        char [] arr = s.toCharArray();

        helper(0,list,ans,s);
        return ans;
    }
    public void helper(int index, List<String> list, List<List<String>> ans, String s){
        if(index >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index ;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                list.add(s.substring(index,i+1));
                helper(i+1,list,ans,s);
                list.remove(list.size()-1);
            }
        }
 
    }
    public boolean isPalindrome(String sb, int i , int j){
         while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    } 
}