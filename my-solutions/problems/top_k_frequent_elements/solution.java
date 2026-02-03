class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();
       int n = nums.length;
        for(int i = 0;i< n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[] > pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
            while(pq.size()>k){
                pq.poll();
            }
        }

        int [] ans = new int[k];
        for(int i =0;i<k;i++){
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}