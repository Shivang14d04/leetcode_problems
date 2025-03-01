
import java.util.*;

public class BinaryGap {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int maxdistance = 0;
        int previous = -1;
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (previous != -1) {
                    maxdistance = Math.max(maxdistance, index - previous);
                }
                previous = index;
            }
            n >>= 1;
            index++;

        }
        return maxdistance;
    }
}
