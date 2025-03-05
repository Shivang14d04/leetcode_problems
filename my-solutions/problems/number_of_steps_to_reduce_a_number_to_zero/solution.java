class Solution {
    public int numberOfSteps(int num) {
    
        return count(num );
        
    }
    public  int count(int num ){
        if(num==0) return 0;
            if(num%2==0){
            
            return 1+count(num/2);

        }
        else{
            
            return 1+count(num-1 );
        }
    }
}