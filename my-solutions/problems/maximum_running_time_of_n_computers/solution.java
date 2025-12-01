class Solution {
    public long maxRunTime(int n, int[] batteries) {
       long Sum = 0;
       for(int power : batteries){
        Sum += power;
       } 
       long start = 1;
       long end = Sum/n;
       while(start<end){
        long target = end - (end-start)/2;
        long extra = 0;
        for(int power : batteries){
            extra += Math.min(power,target);
        }
        if(extra >= target*n){
            start = target;
        }
        else{
            end = target-1;
        }
       }
       return start;
    }
}