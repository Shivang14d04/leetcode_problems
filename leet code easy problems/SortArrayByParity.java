
import java.util.Arrays;

public class SortArrayByParity{
    public static void main(String[] args){
        int [] nums = {3,1,2,4};
        System.out.println(Arrays.toString(solution(nums)));
    }
    public static int [] solution(int [] nums){
     int [] answer = new int[nums.length];
     int k = 0;
     int b = nums.length-1;
     for(int i =0;i<nums.length;i++){
        if(nums[i]%2==0){
            answer[k] = nums[i];
            k++;
        }
        else{
            answer[b] = nums[i];
            b--;
        }
     }
     return answer;         
    }

    
}