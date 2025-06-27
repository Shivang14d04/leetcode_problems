
import java.util.*;

public class FloodFill {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int sr = input.nextInt();
        int sc = input.nextInt();
        int color = input.nextInt();
        int[][] image = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = input.nextInt();
            }
        }

        int originalColor = image[sr][sc];
        if (originalColor != color) {
            solution(sr, sc, originalColor, color, image);
        }
        System.out.println(Arrays.deepToString(image));

    }

    public static void solution(int sr, int sc, int originalColor, int newColor, int[][] image) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (image[sr][sc] != originalColor) {
            return;
        }
        image[sr][sc] = newColor;
        solution(sr + 1, sc, originalColor, newColor, image);
        solution(sr - 1, sc, originalColor, newColor, image);
        solution(sr, sc + 1, originalColor, newColor, image);
        solution(sr, sc - 1, originalColor, newColor, image);
    }
}
