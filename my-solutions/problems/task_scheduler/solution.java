class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        Arrays.sort(freq);
        int idle = (freq[25] -1) *n;
        for(int i = 24;i>=0;i--){
            idle -= Math.min(freq[i],freq[25]-1);
        }
        return Math.max(0,idle) + tasks.length;
    }
}