class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int aCount = 0;
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='a')aCount++;
        }
        int countb = 0;
        int min = n;
        for(int i =0;i<n;i++){
            if(s.charAt(i)=='a') aCount--;
            min = Math.min(min, aCount + countb);
            if(s.charAt(i)=='b')countb++;
        }
        return min;
    }
}