class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack1 = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while (!stack1.isEmpty() && stack1.peek() > a && stack1.size() + nums.length - i > k) {
                stack1.pop();
            }
            if (stack1.size() < k) {
                stack1.push(a);
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack1.pop();
        }
        return result;
    }
}
