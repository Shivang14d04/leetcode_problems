
import java.util.*;

public class BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));
    }

    public static boolean solution(int n) {
        int prevr = -1;
        while (n > 0) {
            int r = n % 2;
            if (prevr == r) {
                return false;
            }

            prevr = r;
            n /= 2;
        }
        return true;
    }
}
