class Solution {
    public int[][] merge(int[][] intervals) {
       if(intervals.length == 1)return intervals;
       Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0])); 
       List<int[]> merged =  new ArrayList<>();
       int [] current = intervals[0];
       merged.add(current);
       for(int [] interval : intervals){
        int nextEnd = interval[1];
        int nextStart  = interval[0];
        int currentEnd = current[1];

        if(currentEnd>= nextStart){
            current[1] = Math.max(currentEnd, nextEnd);
        }
        else{
            current = interval;
            merged.add(interval);


        }
       }
       return merged.toArray(new int[merged.size()][]);
    }
}