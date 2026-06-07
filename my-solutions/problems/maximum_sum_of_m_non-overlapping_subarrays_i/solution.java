class Solution {
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        long[] pre = new long[n+1];
        for(int i =0;i<n;i++){
            pre[i+1] = pre[i]+ nums[i];
        }

        long min = Long.MIN_VALUE/4;
        long[] prev  =new long[n+1];
        long[] curr = new long[n+1];
        Arrays.fill(prev,0);
        long ans = min;

        for(int i = 1;i<=m;i++){
            Arrays.fill(curr,min);
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j = 0;j<=n;j++){
                if(j>0){
                    curr[j] = curr[j-1];
                    
                }
                int add  = j-l;
                if(add>=0){
                    long val = prev[add]-pre[add];
                    while(!dq.isEmpty()){
                        int last = dq.peekLast();
                        long lv = prev[last]-pre[last];
                        if(lv<=val){
                            dq.pollLast();
                        }
                        else{
                            break;
                        }
                    }
                    dq.offer(add);
                }
                int left = j-r;
                while(!dq.isEmpty()&& dq.peekFirst() <left){
                    dq.pollFirst();
                }
                if(!dq.isEmpty()){
                    int s = dq.peekFirst();
                    long d = prev[s]-pre[s];
                    curr[j] = Math.max(curr[j],pre[j]+d);
                }

            }
            ans = Math.max(ans,curr[n]);
            long[] temp = prev;
            prev =curr;
            curr = temp;
        }
        return ans;
    }
}