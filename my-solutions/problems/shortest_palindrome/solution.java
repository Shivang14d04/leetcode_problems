class Solution {
    public String shortestPalindrome(String s) {
        long base = 29;
        long pref = 0;
        long suff = 0;
        long power = 1;
        int lastindex = -1;
        long mod = (long)1e9 + 7;

        for(int i =0;i<s.length();i++){
            int ch  = s.charAt(i)-'a' + 1;
            pref = (pref*base)%mod;
            pref = (pref + ch )%mod;

            suff = (suff + ch*power)%mod;
            power = (base*power)%mod;

            if(pref == suff){
                 lastindex = i;
            }
        }
        String toadd = s.substring(lastindex +1);
        String ans = new StringBuilder(toadd).reverse().toString();
        return ans + s;
    }
}