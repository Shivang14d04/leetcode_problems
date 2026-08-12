class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int s = 0, e = n-1;
        int max = 0;
        while(s<e){
            max = Math.max(max, (Math.min(height[s],height[e])*(e-s)));
            if(height[s]<height[e]){
                s++;}
                else{
                    e--;
                }
            
        }
        return max;
    }
}