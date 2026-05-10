class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        
        StringBuilder temp = new StringBuilder();
        for (String a : chunks) {
            temp.append(a);
        }
        String s = temp.toString();
        HashMap<String, Integer> map = new HashMap<>();

        int n = s.length();
        int i = 0;
        while (i < n) {
            if (!helper(s.charAt(i))) {
                i++;
                continue;
            }
            int start = i;
            i++;
            while (i < n) {
                char ch = s.charAt(i);
                if (helper(ch)) {
                    i++;
                }
                else if (
                    ch == '-' &&
                    i > 0 &&
                    i < n - 1 &&
                    helper(s.charAt(i - 1)) &&
                    helper(s.charAt(i + 1))
                ) {
                    i++;
                }
                else {
                    break;
                }
            }
            String word = s.substring(start, i);
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int[] ans = new int[queries.length];
        for (i = 0; i < queries.length; i++) {
            ans[i] = map.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    public boolean helper(char ch) {
        return ch >= 'a' && ch <= 'z';
    }
}