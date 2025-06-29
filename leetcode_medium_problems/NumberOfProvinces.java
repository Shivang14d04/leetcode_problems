
import java.util.*;

public class NumberOfProvinces {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[][] isConnected = new int[][]{
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }
}
