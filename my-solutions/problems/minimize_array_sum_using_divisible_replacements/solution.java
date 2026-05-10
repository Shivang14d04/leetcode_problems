class Solution {
    public long minArraySum(int[] nums) {

        int max = 100000;
        boolean[] ex = new boolean[max + 1];
        for (int a : nums) {
            ex[a] = true;
        }
        int[] arr = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        for (int j = 1; j <= max; j++) {
            if (!ex[j]) continue;

            for (int k = j; k <= max; k += j) {
                arr[k] = Math.min(arr[k], j);
            }
        }
        long ans = 0;
        for (int a : nums) {
            ans += arr[a];
        }
        
        return ans;
    }
}