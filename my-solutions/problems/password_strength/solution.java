class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : password.toCharArray()){
            set.add(ch);
        }
        int count = 0;
        for(char ch :set){
              if (ch >= 'a' && ch <= 'z') {
                count += 1;
            } 
            else if (ch >= 'A' &&ch <= 'Z') {
                count += 2;
            } 
            else if (ch >= '0'&& ch <= '9') {
                count += 3;
            } 
            else {  
                count += 5;
            }
        }
        return count;
    }
}