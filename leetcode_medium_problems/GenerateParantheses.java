
import java.util.*;

public class GenerateParantheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0, n);
        return result;

    }

    public void helper(List<String> result, String current, int open, int close, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n) {
            helper(result, current + '(', open + 1, close, n);
        }
        if (close < open) {
            helper(result, current + ')', open, close + 1, n);
        }
    }

}
