class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;

        int[] copy = nums;

        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        generate(left, leftMap);
        generate(right, rightMap);

        int maxSize = -1;

        for (int lx : leftMap.keySet()) {
            int need = target ^ lx;

            if (rightMap.containsKey(need)) {
                int size = leftMap.get(lx) + rightMap.get(need);
                maxSize = Math.max(maxSize, size);
            }
        }

        return maxSize == -1 ? -1 : n - maxSize;
    }

    private void generate(int[] arr, Map<Integer, Integer> map) {
        int m = arr.length;

        for (int mask = 0; mask < (1 << m); mask++) {
            int xor = 0;
            int count = 0;

            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= arr[i];
                    count++;
                }
            }

            map.put(xor, Math.max(map.getOrDefault(xor, 0), count));
        }
    }   
    
}