
import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();

        String array = input.nextLine();

        char[] arr = array.toCharArray();
        System.out.println(solution(arr, n));

    }

    public static int solution(char[] arr, int n) {
        int[] frequencies = new int[26];

        for (char task : arr) {
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies);
        int maxFrequency = frequencies[25];
        int maxCount = 0;

        for (int frequency : frequencies) {
            if (frequency == maxFrequency) {
                maxCount++;
            }
        }

        int MinInterval = Math.max((maxFrequency - 1) * (n + 1) + maxCount, arr.length);
        return MinInterval;
    }
}
