class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            int [] freq = new int[26];
            for(char ch: s.toCharArray()){
                freq[ch-'a']++;
            }
            String key =  Arrays.toString(freq);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;

    }
}