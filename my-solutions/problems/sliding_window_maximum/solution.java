class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.getFirst() < i - k + 1) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[i] > nums[q.getLast()]) {
                q.pollLast();
            }
            q.addLast(i);
            if(i>=k-1){
                ans.add(nums[q.getFirst()]);
            }
        }
        int [] res = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            res[i] =ans.get(i);
        }
        return res;
    }
}