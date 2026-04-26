class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        int max1 = Integer.MIN_VALUE;
                int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] > max1) {
                pref[i] = nums[i];
                max1 = pref[i];
            } else {
                pref[i] = -1;
            }
        }

        for (int i = n-1; i >= 0; i--) {
            if (nums[i] > max2) {
                suff[i] = nums[i];
                max2 = suff[i];
            } else {
                suff[i] = -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int  i = 0;i<n;i++){
            if(suff[i] != -1 || pref[i] != -1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}