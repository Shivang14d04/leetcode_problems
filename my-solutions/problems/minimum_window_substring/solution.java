class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        // Step 1: build frequency map for t
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        // Step 2: sliding window
        while (right < s.length()) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    count++;
                }
                map.put(ch, map.get(ch) - 1);
            }

            // Step 3: shrink window
            while (count == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}
