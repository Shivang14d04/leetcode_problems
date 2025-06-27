
import java.util.*;

public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] nums = {1,2,1,10};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int end = nums.length - 1;
        int start = nums.length - 3;
        while (start >= 0 && end >= 0) {
            if (nums[start] + nums[start + 1] > nums[end] && nums[start] + nums[end] > nums[start + 1] && nums[start + 1] + nums[end] > nums[start]) {
                return nums[start] + nums[start + 1] + nums[end];
            } else {
                start--;
                end--;
            }
        }
        return 0;
    }
}
