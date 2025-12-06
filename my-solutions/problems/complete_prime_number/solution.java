class Solution {
    public boolean completePrime(int num) {
        
    if(num<10){
        return Prime(num);
    }        
        String a  = String.valueOf(num);
        for(int i = 1;i<=a.length();i++){
            int prefix = Integer.parseInt(a.substring(0,i));
            int suffix = Integer.parseInt(a.substring(a.length() -i));
            if(!Prime(prefix) || !Prime(suffix)){
                return false;
            }
        }
        return true;
    }
    public boolean Prime(int n){
        if(n<=1){
            return false;
        }
        if(n==2) return true;
        if(n%2==0){
            return false;
        }
        for(int i = 3;i*i<=n;i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}