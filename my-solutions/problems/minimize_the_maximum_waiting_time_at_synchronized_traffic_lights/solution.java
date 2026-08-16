class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max = 0, ans = 0;
        for(int num: lights){
            max = Math.max(num,max);
        }
        for(int num2: arrivalTime){
            int r = num2%period;
            int wait = 0;
            if(r<max){
                wait = 0;
            }
            else{
                wait = period-r;
            }
            ans = Math.max(wait,ans);
        }
        return ans;
    }
}