import java.util.*;
class KthMissingPositiveNumber{
     public static void main(String[] args) {
         int arr[] = {2};
         Scanner inp = new Scanner(System.in);
         int k = inp.nextInt();
          int answer =kthpostivenumber(arr,k);
          System.out.println(answer);


     }
     public  static  int kthpostivenumber(int arr[] , int k){
        int s = 0;
        int e = arr.length-1;
        while(s<=e){
            int mid  = s+(e-s)/2;
            int missing = arr[mid] - (mid+1);
            if(missing<k){
                s = mid +1;
            }
            else{
                e = mid-1;
            }
        }
        return s +k;

     }


}