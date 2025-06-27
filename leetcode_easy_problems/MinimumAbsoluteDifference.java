import java.util.*;
public class MinimumAbsoluteDifference{
    public static void main(String[] args) {
       int [] arr = {3,8,-10,23,19,-4,-14,27};
       System.out.println((solution(arr))); 
    }
    public static List<List<Integer>> solution(int [] arr){
     Arrays.sort(arr);
     int min_diff = Integer.MAX_VALUE;
     for(int i =1;i<arr.length;i++){
        int diff = arr[i] - arr[i-1];
        if(diff<min_diff){
            min_diff = diff;
        }
     }
     List<List<Integer>> answer = new ArrayList<>();

     for(int i =1;i<arr.length;i++){
        int diff = arr[i] - arr[i-1];
        if(diff==min_diff){
     List<Integer> pair = new ArrayList<>();            
            pair.add(arr[i-1]);
            pair.add(arr[i]);
            answer.add(pair);
        }
     }
     return answer;             
    }
}