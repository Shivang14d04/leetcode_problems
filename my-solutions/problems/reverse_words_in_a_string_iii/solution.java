class Solution {
    public String reverseWords(String s) {
        String [] ans = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i =0;i< ans.length;i++){
            result.append(new StringBuilder(ans[i]).reverse());
            if(i==ans.length-1){
                break;
            }            
            result.append(" ");

        }
        return result.toString();
    }
}