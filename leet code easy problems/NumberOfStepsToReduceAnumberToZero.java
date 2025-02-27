
import java.util.*;

public class NumberOfStepsToReduceAnumberToZero {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
                count++;
            } else {
                n -= 1;
                count++;
            }
        }
        return count;
    }
}
