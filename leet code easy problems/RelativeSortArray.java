import java.util.*;
public class RelativeSortArray{
    public static void main(String[] args){
        int [] arr1 ={2,3,1,3,2,4,6,7,9,2,19};
        int [] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }
    public static int[] solution(int[] arr1 , int [] arr2){
       List<Integer> List = new ArrayList<>();
       int [] ans = new int[arr1.length];
       for(int i =0 ; i< arr2.length ;i++){
         for(int j = 0;j< arr1.length;j++){
            if(arr2[i] == arr1[j]){
                List.add(arr1[j]);
                arr1[j] = -1;
            }
        }
    
       }
       Arrays.sort(arr1);
       for(int i =0;i< arr1.length;i++){
        if(arr1[i]!=-1){
            List.add(arr1[i]);
        }
       }
       for(int i =0;i<arr1.length;i++){
        ans[i] = List.get(i);
       }
       return ans;
    }
}