class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans  = new ArrayList<>();
        helper(0,digits,ans,map,new StringBuilder());
        return ans;

    }
    public void helper(int index,String s, List<String> ans, HashMap<Character, String> map,StringBuilder temp){

        if(index >= s.length()){
            ans.add(temp.toString());
            return;
        }

      String letters =   map.get(s.charAt(index));
      for(char ch : letters.toCharArray()){
        temp.append(ch);
        helper(index+1,s,ans,map,temp);
        temp.deleteCharAt(temp.length()-1);
      }

    }
}