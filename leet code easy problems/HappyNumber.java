
import java.util.*;

public class HappyNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution2(n));

    }

    public static boolean solution1(int n) {
        int iterations = 1000;
        while (n != 1 && iterations > 0) {
            n = squareSum(n);
            iterations--;
        }
        return n == 1;
    }

    public static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int r = n % 10;

            sum += r * r;

            n /= 10;
        }
        return sum;

    }

    // Optimized solution
    public static boolean solution2(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) {
                return false;
            }
            seen.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }
}
