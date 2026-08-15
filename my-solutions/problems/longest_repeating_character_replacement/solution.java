class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int ans = 0, maxi = 0;
        int l  =0, r=0;
        int n = s.length();
        for ( r = 0; r < n; r++) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
                maxi = Math.max(maxi, map.get(s.charAt(r)));

                while((r - l + 1) - maxi >k){
                    map.put(s.charAt(l),map.get(s.charAt(l))-1);
                    l++;
                }
                ans = Math.max(ans, (r - l + 1));
            
        }
        return ans;
    }
}