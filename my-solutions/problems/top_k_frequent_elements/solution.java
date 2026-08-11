class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int [] ans = new int[k];
        int i =0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll()[1];
        }
        return ans;

    }
}