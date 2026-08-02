class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        long [] pref = new long[n];
        int [] ans  = new int[shifts.length];
        pref[0] = tasks[0];
        for(int i =1;i<n;i++){
            pref[i] = pref[i-1]+tasks[i];
        }
        long sh = 0;
        for(int i =0;i<shifts.length;i++){
            sh += shifts[i];
            ans[i]  = n - findUb(pref, sh);
            if(ans[i]==0) sh =0;
        }
        return ans;
    }
    public int findUb(long [] pref , long target){
        int start = 0, end  = pref.length -1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(pref[mid]<= target){
                start = mid +1;

            }
            else {
                end = mid -1;
            }

        }
        return start;
    }
}