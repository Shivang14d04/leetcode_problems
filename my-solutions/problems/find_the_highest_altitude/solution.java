class Solution {
    public int largestAltitude(int[] gain) {
        int [] altitude = new int[gain.length+1];
        int max =0;
        altitude[0] = 0;
        for(int i =0;i<gain.length;i++){
            altitude[i+1] = gain[i] + altitude[i];
        }
        for(int i =0;i<gain.length+1;i++){
            if(max< altitude[i]){
                max = altitude[i];
            }
        }
        return max;
    }
}