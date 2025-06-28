
class SearchInRotatedSortedArray{
    public static void main(String[] args){
        int[] arr = {1,3,5};
        int target = 1;
        int start = 0;
        int end = arr.length-1;
        int answer = solution(arr, target, start, end);
        System.out.println(answer);
    }
    public static int solution(int [] arr , int target , int start , int end  ){
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid]>=start ){
                if(target>=arr[start] && target<=arr[mid]){
                    end = mid-1;
                }
                else{
                    start= mid+1;
                }
            }
            else{
                if(target<=arr[end] && target>=arr[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}