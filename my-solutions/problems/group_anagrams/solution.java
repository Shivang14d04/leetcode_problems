class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] freq = new char[26];
            for(char c  : s.toCharArray()){
                freq[c-'a']++;
            }
            String sorted = new String(freq);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(s);

        }
        return new ArrayList<>(map.values());
    }
}