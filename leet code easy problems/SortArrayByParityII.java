
import java.util.Arrays;

public class SortArrayByParityII{
    public static void main(String[] args) {
      int [] nums = {4,2,5,7}; 
      System.out.println(Arrays.toString(solution(nums))); 
    }
    public static int [] solution(int [] nums){
        int even_ptr = 0;
        int odd_ptr =1;
        int [] answer = new int[nums.length];
        for( int i = 0;i<nums.length;i++){
            if(nums[i]%2==0){
                answer[even_ptr] = nums[i];
                even_ptr+=2;
            }
            else{
                answer[odd_ptr] = nums[i];
                odd_ptr+=2;
            }
        }
        return answer;
    }

    
}