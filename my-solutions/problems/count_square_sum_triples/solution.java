class Solution {
    public int countTriples(int n) {
        int count = 0;
     for(int i = 1;i<=n;i++){
        for(int j = 1;j<=n;j++){
            int a = i*i + j*j;
            int c = (int)Math.sqrt(a);
            if(c*c == a && c<=n){
                count++;
            }
        }
     }   
     return count;
    }
}