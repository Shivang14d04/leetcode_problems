
import java.util.Scanner;

public class TargetSum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int target = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(solution(nums, 0, target));

    }

    public static int solution(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // Include +nums[i]
        int add = solution(nums, i + 1, target - nums[i]);

        // Include -nums[i]
        int subtract = solution(nums, i + 1, target + nums[i]);

        return add + subtract;

    }
}
