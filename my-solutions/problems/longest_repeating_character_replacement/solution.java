class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int result = 0;
        int[] arr = new int[26];
        int maxFreq = 0;
        int right =0;
        int left =0;
        while(right<n){
            arr[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,arr[s.charAt(right)-'A']);
            if((right-left+1)-maxFreq >k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            result = Math.max(result,(right-left+1));
            right++;
        }
        return result;


    }  
}