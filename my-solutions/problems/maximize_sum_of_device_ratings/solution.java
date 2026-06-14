class Solution {
    public long maxRatings(int[][] units) {
        long secondSum =0;
        long sum =0;
        int globalMin = Integer.MAX_VALUE;
        int secondMinG = Integer.MAX_VALUE;
        if(units[0].length ==1){
            for(int [] unit : units){
                sum += unit[0];
            }
            return sum;
        }

        for(int [] unit : units){
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for(int i: unit){
                if(i< min){
                    secondMin = min;
                    min = i;
                }
                else if(i< secondMin){
                    secondMin = i;
                }
            }

            globalMin = Math.min(min,globalMin);
            secondMinG = Math.min(secondMin, secondMinG);
            secondSum += secondMin;
        }
        return secondSum + globalMin - secondMinG;
    }
}