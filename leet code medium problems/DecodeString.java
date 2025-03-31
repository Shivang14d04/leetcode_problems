
import java.util.*;

public class DecodeString {

    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String currStr = "";
        int currNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');

            } else if (ch == '[') {
                numStack.push(currNum);
                strStack.push(currStr);
                currNum = 0;
                currStr = "";
            } else if (ch == ']') {
                int repeat = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                while (repeat-- > 0) {
                    temp.append(currStr);
                }
                currStr = temp.toString();

            } else {
                currStr += ch;
            }
        }
        return currStr;

    }
}
