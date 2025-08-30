class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int OriginalColor = image[sr][sc];
        int n = image.length;
        int m = image[0].length;
        if (OriginalColor != color) {
            int[] rowChange = { -1, 0, 1, 0 };
            int[] colChange = { 0, -1, 0, 1 };
            dfs( image, sr, sc, color, OriginalColor, rowChange, colChange,n,m);
        }
        return image;
    }

    public void dfs( int[][] image, int sr, int sc, int color, int OriginalColor, int[] row, int[] col,int n , int m) {
        image[sr][sc] = color;

        for (int i = 0; i < 4; i++) {
            int x = sr + row[i];
            int y = sc + col[i];

            if (x < 0 || y < 0 || x >= n || y >= m || image[x][y] != OriginalColor) {
                continue;
            }
            dfs( image, x, y, color, OriginalColor, row, col,n,m);

        }
    }
}