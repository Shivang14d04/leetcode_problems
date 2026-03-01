import java.util.*;

class Solution {
    public int minimumOR(int[][] grid) {
        int m = grid.length;

        boolean[][] eligible = new boolean[m][];
        for (int i = 0; i < m; i++) {
            eligible[i] = new boolean[grid  [i].length];
            Arrays.fill(eligible[i], true);
        }

        int result = 0;

        for (int b = 16; b >= 0; b--) {
            boolean canAvoid = true;
            for (int i = 0; i < m; i++) {
                boolean found = false;
                for (int j = 0; j < grid[i].length; j++) {
                    if (eligible[i][j] && (grid[i][j] & (1 << b)) == 0) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canAvoid = false;
                    break;
                }
            }

            if (canAvoid) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        if ((grid[i][j] & (1 << b)) != 0) {
                            eligible[i][j] = false;
                        }
                    }
                }
            } else {
                result |= (1 << b);
            }
        }

        return result;
    }
}
