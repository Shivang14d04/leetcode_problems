
import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution1(n));

    }

    public static boolean solution1(int n) {
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }

    public static boolean solution2(int n) {
        if (n == 1) {
            return true;

        }
        return (n & (n - 1)) == 0;
    }

}
