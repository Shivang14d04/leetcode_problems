class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 97]++;
        }
        int[] count = new int[26];

        int l = 0, r = 0;
        for ( r = 0; r < n; r++) {
            count[s2.charAt(r) - 97]++;
            while((r-l+1)>s1.length()){
                count[s2.charAt(l)-97]--;
                l++;
            }
            if (Arrays.equals(freq, count))
                return true;

        }
        return false;
    }
}