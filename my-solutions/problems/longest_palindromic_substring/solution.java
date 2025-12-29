class Solution {
    public String longestPalindrome(String s) {
      int start = 0;
      int n = s.length();
      int end = 0;

      for(int i = 0;i<n;i++){
        int oddLen = expand(s,i,i);
        int evenLen = expand(s,i,i+1);
        int length = Math.max(oddLen,evenLen);

        if(length> end-start){
            start = i - (length-1)/2;
            end = i +  length/2;
        }

      }
              return s.substring(start,end+1);
  
    }
    public int expand(String s, int start , int end){
        while(start >= 0 && end <= s.length()-1 && (s.charAt(start)== s.charAt(end))){
            start--;
            end++;
        }
        return end -start -1;
    }
}