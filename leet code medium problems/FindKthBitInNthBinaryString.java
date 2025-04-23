
import java.util.Scanner;

public class FindKthBitInNthBinaryString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String s = Build(n);
        System.out.println(s.charAt(k - 1));

    }

    public static String Build(int n) {
        if (n == 1) {
            return "0";
        }
        String prev = Build(n - 1);
        return prev + "1" + reverseInvert(prev);
    }

    public static String reverseInvert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch == '1' ? '0' : '1');
        }
        return sb.reverse().toString();

    }
}
