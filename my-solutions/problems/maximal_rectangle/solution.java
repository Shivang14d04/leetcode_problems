class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [] col = new int[m];
        int MaxArea  = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == '1'){
                    col[j]++;
                }
                else{
                    col[j] = 0;
                }
            }
            MaxArea = Math.max(MaxArea, helper(col));

        }
        return MaxArea;
    }

    public int helper(int[] col){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = col.length;
        for(int i = 0;i<=n;i++){
            while(!st.isEmpty() && (i==n || col[st.peek()]>= col[i])){
                int height =col[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i-st.peek()-1;
                }
                maxArea = Math.max(maxArea, height*width);
            }
            st.push(i);
        }
        return maxArea;

    }
}