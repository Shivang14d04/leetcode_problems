
import java.util.ArrayList;
import java.util.Scanner;

public class SelfDividingNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int left = input.nextInt();
        int right = input.nextInt();
        System.out.println(solution(left, right));

    }

    public static ArrayList<Integer> solution(int left, int right) {
        ArrayList<Integer> list = new ArrayList();
        for (int i = left; i <= right; i++) {
            int n = i;
            int num = i;
            while (n > 0) {

                int r = n % 10;
                if (r == 0 || num % r != 0) {
                    break;
                }
                n /= 10;
                if (n == 0) {
                    list.add(num);
                }
            }
        }
        return list;
    }
}
