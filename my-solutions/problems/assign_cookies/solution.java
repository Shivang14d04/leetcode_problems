class Solution {
    public int findContentChildren(int[] g, int[] s) {
      int a = s.length-1;
      int b = g.length-1;
      int count = 0;
      Arrays.sort(g);
      Arrays.sort(s);
      while(a>=0 && b>=0) {
        if(s[a]>=g[b]){
            count++;
            a--;
            b--;
        }
        else{
            b--;
        }
      } 
      return count;
    }
}