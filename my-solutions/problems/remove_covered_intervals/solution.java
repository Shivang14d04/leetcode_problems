class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = 1;
        Arrays.sort(intervals,(a,b)-> a[0]==b[0]? Integer.compare(b[1],a[1]) : Integer.compare(a[0],b[0]));
        int prevl = intervals[0][0];
        int prevR = intervals[0][1];
        for(int [] interval : intervals){
            int l = interval[0] , r = interval[1];
            if(l >= prevl && r <= prevR){
                continue;
            }
            ans++;
            prevR = r;
            prevl = l;
        }
        return ans;
    }
}