
import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k, n)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k, int n) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.pollLast();
            }
            deque.addLast(num);
            if (i >= k && nums[i - k] == deque.getFirst()) {
                deque.pollFirst();
            }
            if (i >= k - 1) {
                result.add(deque.getFirst());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();

    }
}
