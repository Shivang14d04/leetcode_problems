class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length())return false;
       
            String doubleds = s+s;

        
        return doubleds.contains(goal);
    }
}