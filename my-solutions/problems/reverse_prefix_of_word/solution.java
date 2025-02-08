class Solution {
    public String reversePrefix(String word, char ch) {
        int a = word.indexOf(ch);
        if(a != -1){
            return new StringBuilder(word.substring(0,a+1)).reverse().toString()+ word.substring(a+1);
        }
        return word;
        
    }
}