class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            long high = binarySearch(nums, i + 1, n - 1, upper - nums[i] + 1);
            long low  = binarySearch(nums, i + 1, n - 1, lower - nums[i]);

            count += (high - low);   // NO IF CONDITION
        }

        return count;
    }

    // last index where arr[mid] < target
    public long binarySearch(int[] arr, int s, int e, int target) {
        

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (arr[mid]>= target) {
                
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }
}
