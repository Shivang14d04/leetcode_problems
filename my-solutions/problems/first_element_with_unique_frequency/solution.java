class Solution {
    public int firstUniqueFreq(int[] nums) {
        
        int[] arr = nums;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int c : map.values()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        for (int n : arr) {
            int c = map.get(n);
            if (countMap.get(c) == 1) {
                return n;
            }
        }
        
        return -1;
    }
}
