class Solution {
    public String frequencySort(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
      for(char ch: s.toCharArray()){
        map.put(ch, map.getOrDefault(ch,0)+1);
      } 
      List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
      list.sort((a,b)->b.getValue() - a.getValue());
      StringBuilder ans = new StringBuilder();
      for(Map.Entry<Character, Integer> entry : list){
        char ch = entry.getKey();
        int fre  = entry.getValue();
        while(fre>0){
            ans.append(ch);
            fre--;
        }
      } 
          return ans.toString();

    }
}