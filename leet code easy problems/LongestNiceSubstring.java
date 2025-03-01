
import java.util.*;

public class LongestNiceSubstring {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        int n = s.length();
        String longestNice = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > longestNice.length()) {
                    longestNice = sub;
                }
            }
        }
        return longestNice;
    }

    public static boolean isNice(String s) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = 1;
            } else {
                upper[c - 'A'] = 1;
            }
        }

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c) && upper[c - 'a'] == 0) {
                return false;
            }
            if (Character.isUpperCase(c) && lower[c - 'A'] == 0) {
                return false;
            }
        }

        return true;
    }
}
