class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0 , high = m-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int row = FidMax(mat, mid);
            int left = mid - 1 >=0 ? mat[row][mid-1] : Integer.MIN_VALUE;
            int right = mid +1 <= m-1? mat[row][mid+1] : Integer.MIN_VALUE;
            if(mat[row][mid] > left && right < mat[row][mid]){
                return new int[]{row,mid};
            }
            else if(mat[row][mid] < left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public int FidMax(int [][] arr , int col){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = 0;i< n;i++){
            if(arr[i][col] > max){
                max = arr[i][col];
                ans = i;
            }
        }
        return ans;
    }
}