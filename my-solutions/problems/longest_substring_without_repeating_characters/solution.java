class Solution {
    public int lengthOfLongestSubstring(String s){
        int [] Hash = new int[256];
        int n = s.length();
        Arrays.fill(Hash,-1);
        int l = 0, r= 0;
        int maxLength = 0;
        while(r<n){
            if(Hash[s.charAt(r)]!= -1){
                if(Hash[s.charAt(r)]>=l){
                    l = Hash[s.charAt(r)]+1;
                }
            }
            maxLength = Math.max(maxLength , r-l+1);
            Hash[s.charAt(r)] = r;
            r++;
        }
        return maxLength;
    }
}