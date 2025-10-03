class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (list.isEmpty() || intervals[i][0] > list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            list.get(list.size() - 1).set(1, Math.max(intervals[i][1], list.get(list.size() - 1).get(1)));

        }
        int m = list.size();
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                ans[i][j] = list.get(i).get(j);
            }
        }

        return ans;

    }
}