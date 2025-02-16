class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a)||isPalindrome(b)){
            return true;
        }

    return checkprefixSuffix(a,b)||checkprefixSuffix(b,a);

    }
        private boolean checkprefixSuffix(String a, String b) {
        int left = 0, right = b.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        return isPalindrome(a.substring(left, right + 1)) || isPalindrome(b.substring(left, right + 1));
    }
    
     public static  boolean isPalindrome(String string){
        int s = 0;
        int e = string.length()-1;
        if(string.length()==1){
            return true;
        }
        while(s<e){
            if(string.charAt(s)==string.charAt(e)){
                s++;
                e--;
            }
            else{
                return false;
            }
        }
        return true;
    }    
}