import java.util.*;
class SearchInsertPosition{
public static void main(String[] args){
    int arr[] = {1,3,5,6};
    Scanner input = new Scanner(System.in);
    int target  = input.nextInt();
    int answer = find_answer(arr, target);
    System.out.println(answer);

    
}
public static  int find_answer(int arr[] , int target){
int s = 0;
int e = arr.length-1;
while(s<=e){
    int mid = s +(e-s)/2;
    if(arr[mid] == target){
        return mid;
    }
    else if(arr[mid]> target){
        e  = mid -1;
    }
    else{
        s = mid +1;
    }
}
return s;
}
}