
import java.util.Scanner;

public class XOR_OperationInAnArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int start = input.nextInt();
        System.out.println(solution(n, start));
    }

    public static int solution(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int result = nums[0];

        for (int j = 1; j < nums.length; j++) {
            result ^= nums[j];
        }
        return result;

    }
}
