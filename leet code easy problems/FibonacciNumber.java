
import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution2(n));
    }

    static int solution1(int n) {
        if (n < 2) {
            return n;
        } else {
            return solution1(n - 1) + solution1(n - 2);
        }
    }

    static int solution2(int n) {
        if (n < 2) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;;
        }

        return b;
    }
}
