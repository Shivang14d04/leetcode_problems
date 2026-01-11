class Solution {
    public int residuePrefixes(String s) {

HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int count =0;
            for(int j = 0;j<n;j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.size() == (j+1)%3 ){
                    count++;
                }
            }
            return count;
    }
}