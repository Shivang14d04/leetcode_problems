class Solution {
    public int largestPrime(int n) {
      int [] prime = new int[n+1];
        Arrays.fill(prime,1);
        prime[1]=0;
        for(int i = 2;i*i<=n;i++){
            if(prime[i] ==0)continue;
            for(int j = i*i;j<=n;j+=i){
                
                prime[j]=0;
            }
        }
        int max = -1;
        long sum = 0;
        for(int i =2;i<=n;i++){
            if(prime[i]==1){
                sum += i;
                if(sum>n)break;
                if(sum <=n  && prime[(int)sum] ==1){
                    max  = (int)sum;
                }
            }
        }
        return max == -1 ? 0: max;
    }
}