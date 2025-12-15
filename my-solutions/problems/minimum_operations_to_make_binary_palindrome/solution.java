class Solution {

    public int[] minOperations(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = minSteps(nums[i]);
        }
        return nums;
    }

    private int minSteps(int number) {
        if (isBinaryPalindrome(number)) return 0;

        int diff = 1;
        while (true) {
            if (number - diff >= 0 && isBinaryPalindrome(number - diff))
                return diff;

            if (isBinaryPalindrome(number + diff))
                return diff;

            diff++;
        }
    }

    private boolean isBinaryPalindrome(int number) {
        String s = Integer.toBinaryString(number);
        return isPalindrome(s);
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}