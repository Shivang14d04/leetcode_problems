class Solution {
    public int peakIndexInMountainArray(int[] arr) {
      int s = 0;
      int e = arr.length-1;

      while(s<=e){
        int mid = s+(e-s)/2;
        if(arr[mid+1]<arr[mid]){
            e = mid -1;
        }
        else{
            s = mid+1;
        }
      } 
      return s; 
    }
}