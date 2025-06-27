import java.util.*;
public class HeightChecker{
    public static void main(String[] args) {
        int [] heights = {1,1,4,2,1,3};
        System.out.println(solution(heights));
    }
    public static int solution(int [] heights){
        int[] expected = heights.clone();
        
    
        Arrays.sort(expected);
        
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;        
    }
}