class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
       int a = num.length;
       List<Integer> result = new ArrayList<>();
        int i = a-1;
        while(i>=0|| k>0){
            if(i>=0){
                k+=num[i];
            }
            result.add(0,k%10);
            k/= 10;
            i--;
        }
     return result;
    }
}