import java.util.*;
public class ThirdMaximumNumber{
    public static void main(String[] args) {
        int [] nums ={2,2,3,1};
        System.out.println(solution(nums));
              
    }
    public static int solution(int [] nums){
       Arrays.sort(nums);
       int max = nums[nums.length-1];
       int distinct_count = 1;
       for(int i = nums.length-2;i>=0;i--){
        if(nums[i]!=max){
            max = nums[i];
            distinct_count++;
        }
        if(distinct_count==3){
            return max;
        }
       }
       return nums[nums.length-1];         
    }
}