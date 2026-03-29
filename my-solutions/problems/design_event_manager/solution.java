class EventManager {
    PriorityQueue<int[]> pq;
    Map<Integer, Integer> map ;

    public EventManager(int[][] events) {
        pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return b[1]- a[1];
            return a[0] - b[0];
        });
            map  = new HashMap<>();
        for(int [] a: events ){
            map.put(a[0], a[1]);
            pq.offer(new int[]{a[0],a[1]});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId, newPriority);
        pq.offer(new int[]{eventId, newPriority});
    }
    
    public int pollHighest() {
        while(!pq.isEmpty()){
        int [] temp = pq.poll();
        int ans = temp[0];
        int priority = temp[1];
            if(map.containsKey(ans) && map.get(ans) == priority){
                map.remove(ans,priority);
                return ans;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */