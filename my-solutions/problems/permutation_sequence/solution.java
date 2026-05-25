class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers  = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<n;i++){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k-1;
        while(true){
            sb.append(numbers.get(k/fact));
            numbers.remove(k/fact);
            if(numbers.isEmpty()){
                break;
            }
            k = k%fact;
            fact = fact/numbers.size();
        }
        return sb.toString();
    }
}