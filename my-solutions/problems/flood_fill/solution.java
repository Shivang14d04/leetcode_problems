class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor!=color){
            solution(sr , sc , originalColor , color , image);
        }
        return image;
    }

    public void  solution(int sr , int sc , int originalColor , int newColor , int [][] image){
        if(sr<0 || sr >= image.length || sc<0 || sc >= image[0].length) return;
        if(image[sr][sc] != originalColor) return;
        image[sr][sc] = newColor;
        solution(sr+1 , sc ,originalColor , newColor , image);
        solution(sr-1 , sc ,originalColor , newColor , image);
        solution(sr , sc+1 ,originalColor , newColor , image);
        solution(sr , sc-1 ,originalColor , newColor , image);
    }
}