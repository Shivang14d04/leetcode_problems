
import java.util.*;

public class RemoveAllAdjacentElements {

    public String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);

            }
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            result.append(stack.get(i));
        }
        return result.reverse().toString();

    }
}
