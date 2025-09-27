import java.util.*;
public class MaximumSubArraySum{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, ansStart = -1, ansEnd = -1;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum == 0) start = i;

            currentSum += nums[i];

            if (currentSum > max) {
                max = currentSum;
                ansStart = start;
                ansEnd = i;
            }

            if (currentSum < 0) currentSum = 0;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = ansStart; i <= ansEnd; i++) {
            list.add(nums[i]);
        }

        System.out.println("Maximum Subarray Sum: " + max);
        System.out.println("Subarray: " + list);
    }
}