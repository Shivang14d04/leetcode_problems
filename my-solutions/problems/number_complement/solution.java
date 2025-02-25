class Solution {
    public int findComplement(int num) {
        if(num==0) return 1;
        int bitlength = Integer.toBinaryString(num).length();
        int mask = (1<< bitlength) -1;
        return num^mask;
        
    }
    
}