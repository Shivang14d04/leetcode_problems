
import java.util.Scanner;

public class PowerOfFour {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution1(n));
    }

    public static boolean solution1(int n) {
        if (n == 1) {
            return true;
        }
        for (int i = 0; i <= 15; i++) {
            int a = (int) Math.pow(4, i);
            if (a == n) {
                return true;
            }
            if (a > n) {
                return false;
            }
        }
        return false;
    }

    public static boolean solution2(int n) {
        if (n == 1) {
            return true;
        }

        if (n <= 0) {
            return false;
        }

        double logbase4 = Math.log(n) / Math.log(4);
        return (logbase4 == (int) logbase4);

    }

    public static boolean solution3(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 4 != 0) {
            return false;
        }
        return solution3(n / 4);
    }
}
