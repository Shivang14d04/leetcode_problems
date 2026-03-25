class Solution {
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        int first = countVovels(words[0]);
        for(int i = 1;i<words.length;i++){
            if(countVovels(words[i])== first){
                words[i] = reverse(words[i]);
            }
        }
        return String.join(" ", words);

        
    }
    public int countVovels(String s){
            int count = 0;
            for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a' || ch =='e' || ch == 'i' || ch == 'o' ||ch == 'u'){
                count ++;
            }
                
        }
        return count;
    }
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}