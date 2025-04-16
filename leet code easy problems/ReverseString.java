
import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();

        char[] s = string.toCharArray();
        System.out.println(Arrays.toString(solution(s)));
    }

    static char[] solution(char[] s) {
        int a = 0;
        int e = s.length - 1;
        while (a <= e) {
            char temp = s[a];
            s[a] = s[e];
            s[e] = temp;
            a++;
            e--;
        }
        return s;
    }
}
