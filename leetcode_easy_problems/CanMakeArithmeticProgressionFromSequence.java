import java.util.*;
public class CanMakeArithmeticProgressionFromSequence{
    public static void main(String[] args) {
        int [] arr = {3,5,1};
        System.out.println(solution(arr));

    }
    public static boolean  solution(int [] arr){
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];  // Calculate initial difference
        
        for (int i = 2; i < arr.length; i++) {  // Start loop from the third element
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;        
    }
}