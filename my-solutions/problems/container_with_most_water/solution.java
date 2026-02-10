class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int l = 0;
        int r = n-1;
        while(l<r){
                max = Math.max(Math.min(height[l], height[r]) * (r - l), max);
                if(height[l]<height[r]){
                    l++;
                }
                else{
                    r--;
                }

    
            
        }
        return max;
    }
}