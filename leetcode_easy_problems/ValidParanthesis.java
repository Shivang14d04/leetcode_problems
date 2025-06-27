public class ValidParanthesis{
    public static void main(String[] args) {
        String s = "(){()}";
              int prevLength;
        do {
            prevLength = s.length();
            s = s.replace("()", "")
                 .replace("[]", "")
                 .replace("{}", "");
        } while (s.length() != prevLength); 

        System.err.println(s.isEmpty());
    }
}