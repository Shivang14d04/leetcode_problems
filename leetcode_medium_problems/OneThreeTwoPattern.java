
import java.util.*;

public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;

    }
}
