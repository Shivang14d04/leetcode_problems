class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int [] freq = new int[26];
        for(char ch: tasks){
            freq[ch - 'A']++;
        }
        for(int count : freq){
            if(count>0) pq.add(count);
        }

        Queue<int[]> q = new LinkedList<>();
        int time  =0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time ++;
            if(pq.isEmpty()){
                time = q.peek()[1];
            }
            else{
                int count = pq.poll()-1;
                if(count >0){
                    q.add(new int[]{count, time +n});
                }
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }
        return time;


    }
}