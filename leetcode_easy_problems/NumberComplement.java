
import java.util.*;

public class NumberComplement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.println(solution(num));

    }

    public static int solution(int num) {
        if (num == 0) {
            return 1;
        }
        int bitlength = Integer.toBinaryString(num).length();
        int mask = (1 << bitlength) - 1;
        return num ^ mask;

    }
}
