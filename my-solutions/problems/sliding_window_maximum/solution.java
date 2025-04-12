class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // store indices

        for (int i = 0; i < nums.length; i++) {
            // Remove indices that are out of the current window
            if (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements from the back
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // Record result starting from window size k
            if (i >= k - 1) {
                result.add(nums[deque.getFirst()]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
