import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // Create a copy of the original array
        int[] expected = heights.clone();
        
        // Sort the copy
        Arrays.sort(expected);
        
        // Count how many heights are out of order
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
}
