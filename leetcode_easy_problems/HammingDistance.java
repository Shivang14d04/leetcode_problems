
import java.util.*;

public class HammingDistance {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println(solution(x, y));

    }

    public static int solution(int x, int y) {
        int a = x ^ y;
        int count = 0;
        while (a > 0) {
            int r = a % 2;
            if (r == 1) {
                count++;
            }
            a /= 2;
        }
        return count;
    }
}
