
import java.util.Scanner;

public class PowOfx {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double x = input.nextDouble();
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        System.out.println(solution(x, N));
    }

    public static double solution(double x, long n) {
        double result = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= x;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }
}
