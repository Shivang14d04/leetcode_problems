class Solution {
    public int minCost(int n) {
        int cost  = 0;
    if(n==1)return 0;
        while(n>1){
            n = n-1;
            cost += n;
        }
        return cost;
    }
}