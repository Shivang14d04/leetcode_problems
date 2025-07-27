
import java.util.*;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<String> current = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, current, result);
        return result;

    }

    public void helper(String s, int i, List<String> current, List<List<String>> result) {
        if (i >= s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                current.add(s.substring(i, j + 1));
                helper(s, j + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
