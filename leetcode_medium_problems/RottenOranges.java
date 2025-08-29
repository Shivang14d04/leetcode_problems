import java.util.*;
public class RottenOranges {
    // time complexity o(N*N)*4
    // space complexity o(N*N)
       public int orangesRotting(int[][] grid) {
        if(grid.length==0)return 0;
        int row = grid.length;
        int col = grid[0].length;
        int freshOranges = 0;
        
        int minutes=0;

        int[][] visited = grid;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(visited[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                if(visited[i][j] ==1){
                    freshOranges++;
                }
            }
        }
        int [] rowDirection = {0,1,-1,0};
        int [] colDirection ={1,0,0,-1};

        while(!q.isEmpty()){
            int size = q.size();
           
            for(int i =0;i<size;i++){
                int[] rotten = q.poll();
                for(int j = 0;j<4;j++){
                    int x = rotten[0] +rowDirection[j];
                    int y = rotten[1] + colDirection[j];

                    if(x<0 || y<0 || x >=row || y>=col || visited[x][y] !=1){
                        continue;
                    }
                    visited[x][y] =2;
                    q.offer(new int[]{x,y});
                    freshOranges--;
                }
            }
            if(!q.isEmpty()){
                minutes++;
            }
        }
        return freshOranges == 0 ? minutes:-1;
        
    }
}