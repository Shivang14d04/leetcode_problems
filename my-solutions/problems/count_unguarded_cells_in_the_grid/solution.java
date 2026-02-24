class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] nums = new int[m][n];
        int count = 0;
        for(int [] a: guards){
            nums[a[0]][a[1]] = 1;
        }
        for(int [] b: walls){
            nums[b[0]][b[1]] = 2;
        }
        int [][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int [] pos : guards){
            for(int [] d : direction){
                int r = pos[0] +d[0];
                int c = pos[1] + d[1];
                while(r<m && c<n && r >=0 && c>=0){
                    if(nums[r][c]==1 || nums[r][c]==2){
                        break;
                    }
                    nums[r][c] = 3;
                    r = r + d[0];
                    c = c + d[1];
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(nums[i][j]==0)count++;
            }
        }
        return count;
    }
}