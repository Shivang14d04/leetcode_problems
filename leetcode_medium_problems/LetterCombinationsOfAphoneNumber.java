
import java.util.*;

public class LetterCombinationsOfAphoneNumber {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> digitToLetter = new HashMap<>();
        digitToLetter.put('2', "abc");
        digitToLetter.put('3', "def");
        digitToLetter.put('4', "ghi");
        digitToLetter.put('5', "jkl");
        digitToLetter.put('6', "mno");
        digitToLetter.put('7', "pqrs");
        digitToLetter.put('8', "tuv");
        digitToLetter.put('9', "wxyz");

        helper(digits, 0, new StringBuilder(), result, digitToLetter);
        return result;

    }

    public void helper(String digits, int index, StringBuilder ans, List<String> result, Map<Character, String> digitToLetter) {
        if (index == digits.length()) {
            result.add(ans.toString());
            return;
        }

        String letters = digitToLetter.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            ans.append(ch);
            helper(digits, index + 1, ans, result, digitToLetter);
            ans.deleteCharAt(ans.length() - 1);
        }
    }
}
