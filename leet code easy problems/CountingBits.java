
import java.util.*;

public class CountingBits {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(Arrays.toString(solution(n)));

    }

    public static int[] solution(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while (num > 0) {
                count += num & 1;
                num >>= 1;

            }
            answer[i] = count;

        }

        return answer;

    }
}
