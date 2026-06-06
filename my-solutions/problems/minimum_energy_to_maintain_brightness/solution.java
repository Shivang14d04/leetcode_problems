class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int m = intervals.length;
        Arrays.sort(intervals,(a,b)->
                   Integer.compare(a[0],b[0])
                   );
        long time = 0;
        long s = intervals[0][0];
        long e = intervals[0][1];

        for(int i =1;i<m;i++){
            if(intervals[i][0] <= e+1){
            e = Math.max(e,intervals[i][1]);                
            }
            else{
                time += e-s+1;
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }

        time += e - s+1;
        long count =(brightness + 2L)/3;

            return count*time;
    }
}