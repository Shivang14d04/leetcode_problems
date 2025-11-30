class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        for (int num : nums) {
            total  = (total + num)%p;
        }
        int rem =  total % p;
        if (rem == 0)
            return 0;

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int ans = n;
        
        for (int i = 0; i < n; i++) {
            prefix = (prefix + nums[i]) % p;
            int target = (prefix - rem + p) % p;
            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }
            map.put(prefix, i);
        }
        return ans == n ? -1 : ans;

    }
}