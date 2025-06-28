
import java.util.*;

public class DifferentWaysToAddParanthesis {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        System.out.println(diffWaysToCompute(expression));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftResult = diffWaysToCompute(left);
                List<Integer> rightResult = diffWaysToCompute(right);

                for (int l : leftResult) {
                    for (int r : rightResult) {
                        int result = 0;
                        switch (ch) {
                            case '+':
                                result = l + r;
                                break;
                            case '-':
                                result = l - r;
                                break;
                            case '*':
                                result = l * r;
                                break;
                        }
                        answer.add(result);
                    }
                }
            }
        }
        if (answer.isEmpty()) {
            answer.add(Integer.parseInt(expression));
        }
        return answer;
    }
}
