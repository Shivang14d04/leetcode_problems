
import java.util.*;

public class WordBreak {
    // brute force solution

    public boolean wordBreak(String s, List<String> wordDict) {

        return helper(s, wordDict);

    }

    public boolean helper(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                String suffix = s.substring(i);
                if (helper(suffix, wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wordBreakOptimized(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
