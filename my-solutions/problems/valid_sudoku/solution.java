class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.')
                    continue;
                if (nums[ch - '0'] != 0)
                    return false;
                nums[ch - '0']++;
            }
        }
        for (int i = 0; i < 9; i++) {
            int[] nums = new int[10];

            for (int j = 0; j < 9; j++) {
                char ch = board[j][i];
                if (ch == '.')
                    continue;
                if (nums[ch - '0'] != 0)
                    return false;
                nums[ch - '0']++;
            }
        }
        for (int k = 0; k < 9; k++) {
            int[] nums = new int[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (k / 3) * 3 + i;
                    int col = (k % 3) * 3 + j;
                    char ch = board[row][col];
                    if (ch == '.')
                        continue;
                    if (nums[ch - '0'] != 0)
                    return false;    
                    nums[ch-'0']++;

                }
            }
        }
        return true;

    }
}