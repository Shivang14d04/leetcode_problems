import java.util.*;
public  class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
     int [] nums = {4,3,2,7,8,2,3,1};  
     System.out.println(solution(nums));  
    }
    public  static List<Integer> solution(int[] nums){
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                ans.add(index + 1);
            }
        }
        return ans;        
    }

    
}