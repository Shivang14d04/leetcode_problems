import java.util.Stack;

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [] col = new int[m];
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] =='1'){
                    col[j]++;
                }
                else{
                    col[j] = 0;
                }
            }
            int area = largestRectangleArea(col);
             maxArea = Math.max(area,maxArea);
        }
        return maxArea;
        
    }
    public  int largestRectangleArea(int [] histo) {
        Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}
