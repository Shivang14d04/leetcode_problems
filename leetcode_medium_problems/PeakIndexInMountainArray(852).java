

class PeakIndexInMountainArray{
    public static void main(String[]args){
        int [] arr ={0,2,1,0};
        int answer = answer(arr);
        System.out.println(answer);

        
    }
    public static  int answer(int [] arr){
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(arr[mid+1]<arr[mid]){
                e = mid -1;

            }
            else{
                s = mid +1;
            }
        }
        return s;

    }
}