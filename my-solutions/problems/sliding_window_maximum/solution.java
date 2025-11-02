class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        
        int n  = nums.length;
        for(int i =0;i<n;i++){
            if(!q.isEmpty() && q.getFirst()< i-k+1){
                q.pollFirst();
            }

            while(!q.isEmpty() && nums[q.getLast()]< nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            if(i>=k-1){
                list.add(nums[q.getFirst()]);
            }
            
        }
        int [] ans = new int[list.size()];
        for(int i=0 ;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}