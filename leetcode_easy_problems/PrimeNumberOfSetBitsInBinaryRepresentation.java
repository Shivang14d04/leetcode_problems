
import java.util.*;

public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int left = input.nextInt();

        int right = input.nextInt();
        System.out.println(solution(left, right));

    }

    public static int solution(int left, int right) {
        int countf = 0;

        for (int i = left; i <= right; i++) {
            int count = Integer.bitCount(i);
            if (isPrime(count)) {
                countf++;
            }
        }
        return countf;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
