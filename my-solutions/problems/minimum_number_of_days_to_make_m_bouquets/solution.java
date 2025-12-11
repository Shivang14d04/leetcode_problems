class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long totalFlowers = (long)m*k;

        if(totalFlowers>bloomDay.length)return -1;
        int start = Arrays.stream(bloomDay).min().getAsInt();
        int end = Arrays.stream(bloomDay).max().getAsInt();
        int result = -1;
        while(start<=end){

            int mid = start +(end -start)/2;
            if(Ispossible(bloomDay,m,mid,k)){
                result = mid;
                end = mid -1;
            }
            else{
                start  = mid +1;
            }
        }
        return result;        

    }
    public boolean Ispossible(int[] arr, int m ,int day, int k){
        int count = 0;
        int buq = 0;
        for(int a : arr){
            if(a<=day){
                count++;
                if(count==k){
                    buq++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }

        return buq>=m;
    }
}