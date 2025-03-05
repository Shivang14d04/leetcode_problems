class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = left ; i <= right ; i++){
            int n = i;
            int num = i;
            while(n>0){
                
                int r = n%10;
                if(r==0 || num%r!=0){
                    break;
                }
                n /=10;
                if(n==0){
                    list.add(num);
                }
            }
        }
        return list;
        
    }
}