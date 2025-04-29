
import java.util.*;

public class FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        System.out.println(solutionUsingRecursion(n, k) + 1);
    }

    public static int solutionUsingQueue(int n, int k) {
        Queue<Integer> ans = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            ans.offer(i);
        }

        while (ans.size() != 1) {
            int a = k;
            while (a > 1) {
                int b = ans.poll();
                ans.offer(b);
                a--;
            }
            ans.poll();
        }

        return ans.peek();

    }

    public static int solutionUsingRecursion(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (solutionUsingRecursion(n - 1, k) + k) % n;
    }
}
