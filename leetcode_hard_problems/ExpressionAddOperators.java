
import java.util.*;

public class ExpressionAddOperators {

    // brute force solution
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(num, target, 0, "", 0, 0, result);
        return result;
    }

    private void backtrack(String num, int target, int index, String expression, long currentValue, long lastOperand, List<String> result) {
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            String substring = num.substring(index, i + 1);
            long operand = Long.parseLong(substring);

            if (i > index && substring.charAt(0) == '0') {
                continue; // skip leading zero numbers
            }

            if (index == 0) {
                // First operand
                backtrack(num, target, i + 1, substring, operand, operand, result);
            } else {
                // Addition
                backtrack(num, target, i + 1, expression + "+" + substring, currentValue + operand, operand, result);
                // Subtraction
                backtrack(num, target, i + 1, expression + "-" + substring, currentValue - operand, -operand, result);
                // Multiplication
                backtrack(num, target, i + 1, expression + "*" + substring,
                        currentValue - lastOperand + lastOperand * operand,
                        lastOperand * operand,
                        result);
            }
        }
    }
}
