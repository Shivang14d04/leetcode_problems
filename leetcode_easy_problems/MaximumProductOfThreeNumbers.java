import java.util.*;
public class MaximumProductOfThreeNumbers{
    public static void main(String[] args) {
        int [] nums  ={1,2,3,4};
        System.out.println(solution(nums));
    
    }
    public static int solution(int [] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int answer = Math.max(nums[n-1]*nums[n-2]*nums[n-3] , nums[0]*nums[1]*nums[n-1]);
        return answer;
    }
}