class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = squareSum(n);
        }
        return n == 1;
        
    }
    public static int squareSum(int n ){
        int sum  = 0;
        while(n>0){
            int r = n%10;
            sum += r*r;

            n/=10;
        }
        
        return sum;
    }
}