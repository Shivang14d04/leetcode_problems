class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int a :map.values()){
                min = Math.min(min,a);
                max = Math.max(max,a);
            }
            ans += (max-min);

            }

        }
        return ans;
    }
}