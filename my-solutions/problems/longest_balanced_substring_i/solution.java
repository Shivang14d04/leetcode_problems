class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int res = 0;
        for(int i =0;i<n;i++){
            Arrays.fill(freq,0);
            for(int j = i;j<n;j++){
                boolean flag =true;
                int c = s.charAt(j)-'a';
                freq[c]++;

                for(int a: freq){
                    if(a>0 && a!= freq[c]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res;
    }
}