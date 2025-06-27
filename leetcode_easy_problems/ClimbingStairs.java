
import java.util.Scanner;

public class ClimbingStairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));
    }

    private static int solution(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = prev + current;
            prev = temp;
        }
        return current;
    }
}
