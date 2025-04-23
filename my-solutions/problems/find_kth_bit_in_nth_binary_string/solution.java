class Solution {
    public char findKthBit(int n, int k) {
        String s = Build(n);
        return s.charAt(k-1);
    }
    public String Build(int n ){
        if(n==1){
            return "0";
        }
        String prev = Build(n-1);
        return prev +"1" + reverseInvert(prev);
    }
    public String reverseInvert(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            sb.append(ch== '1' ? '0':'1');
        }
        return sb.reverse().toString();


    }
}