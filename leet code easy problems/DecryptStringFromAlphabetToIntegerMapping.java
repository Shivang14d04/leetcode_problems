
public class DecryptStringFromAlphabetToIntegerMapping {

    public static void main(String[] args) {
        String s = "10#11#12";
        StringBuilder ans = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int num;
            if (s.charAt(i) == '#') {
                num = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                i -= 2;
            } else {
                num = s.charAt(i) - '0';
            }
            ans.append((char) (num + 96));
        }
        System.out.println(ans.reverse().toString());
    }
}
