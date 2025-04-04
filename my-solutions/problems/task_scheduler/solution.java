class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] frequencies = new int[26];

        for(char task : tasks){
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies);
        int maxFrequency = frequencies[25];
        int maxCount = 0;

        for(int frequency : frequencies){
            if(frequency == maxFrequency){
                maxCount++;
            }
        }

        int MinInterval = Math.max((maxFrequency - 1)* (n+1) +maxCount , tasks.length);
        return MinInterval;
    }
}