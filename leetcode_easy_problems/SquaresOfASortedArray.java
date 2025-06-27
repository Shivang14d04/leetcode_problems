import java.util.*;
public class SquaresOfASortedArray{
    public static void main(String[] args) {
        int [] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(solution(nums)));
    }
    public static int [] solution(int [] nums){
       int [] ans = new int[nums.length];
       int k = 0;
       for(int i =0 ; i< nums.length;i++){
        ans[k] = nums[i]*nums[i];
        k++;
       }
       Arrays.sort(ans);
       return ans;         
    }
}