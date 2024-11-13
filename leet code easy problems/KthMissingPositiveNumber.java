import java.util.*;
class KthMissingPositiveNumber{
     public static void main(String[] args) {
         int arr[] = {1,2,3,4};
         Scanner inp = new Scanner(System.in);
         int k = inp.nextInt();
          int answer =kthpostivenumber(arr,k);
          System.out.println(answer);


     }
     public  static  int kthpostivenumber(int arr[] , int k){
         int sum = 1;
         int missingCount = 0;
         int index = 0;
         while(missingCount<k){
            if(index<arr.length && sum  == arr[index]){
                index++;
            }
            else{
                missingCount++;
                if(missingCount==k){
                    return sum;
                }
            }
            sum++;
         }
         return -1;

     }


}