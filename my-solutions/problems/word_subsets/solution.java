class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();
        int [] freq2 = new int[26];
        for(String s: words2){
            int [] temp = new int[26];
            for(int i =0;i<s.length();i++){
                temp[s.charAt(i)-'a']++;
            }
            for(int i =0;i<26;i++){
                freq2[i] = Math.max(freq2[i], temp[i]); 
            }
        }
        for (String b : words1) {
            boolean isValid = true;
            int[] freq = new int[26];
            for (int i = 0; i < b.length(); i++) {
                freq[b.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (freq2[i] > freq[i]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) ans.add(b);

        }
        return ans;
    }
}