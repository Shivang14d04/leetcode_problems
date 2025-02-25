class Solution {
    public int hammingDistance(int x, int y) {
    int a = x^y;
    int count =0;
    while(a>0){
        int r = a%2;
        if(r==1){
            count ++;
        }
    a/=2;

    }
    return count;
        
    }
}