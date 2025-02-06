class Solution {
    public boolean validPalindrome(String s) {
        char [] arr = s.toCharArray();

        if(s.length()==0 || s.length()==1||s.length()==2){
            return true;
        }
        int start =0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!= s.charAt(end)){
             return isPalindrome(s,start+1,end) || isPalindrome(s,start,end-1);
            }
            else{
                start++;
                end--;
            }
        }
        return true;
        
    }

    public boolean isPalindrome(String s , int start , int end){
    while(start < end){
        if(s.charAt(start)!= s.charAt(end)){
            return false;
        }
        start++;
        end--;
    }
    return true;

}
}
