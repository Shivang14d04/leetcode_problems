class Solution {
    public int largestRectangleArea(int[] heights) {
       Stack<Integer> st  = new Stack<>();
       int n = heights.length;
    int maxArea  = Integer.MIN_VALUE;
       for(int i = 0;i<=n;i++){
        while(!st.isEmpty() && ( i==n || heights[st.peek()]>=heights[i])){
            int height = heights[st.peek()];
                        st.pop();

            int width =0;
            if(st.isEmpty()){
                width = i;
            }
            else{
                width = i - st.peek() -1;
            }
            maxArea = Math.max(maxArea, height *width);

        }
        st.push(i);
       }
       return maxArea;

    }
}