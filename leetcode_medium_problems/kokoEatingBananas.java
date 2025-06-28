public class kokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {805306368,805306368,805306368};
        int h = 1000000000;
        int start = 1;
        int end = getMaxPile(piles);
        int answer = solution(start, end, piles, h);
        System.out.println("Minimum eating speed: " + answer);
    }

    // Helper function to determine if Koko can eat all bananas in h hours at speed k
    public static boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            // Add the number of hours required for each pile
            hours += (pile + k - 1) / k; // Ceiling division
            if (hours > h) {
                return false; // Exit early if hours exceed h
            }
        }
        return true;
    }

    // Binary search to find the minimum speed
    public static int solution(int start, int end, int[] piles, int h) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canEatInTime(piles, mid, h)) {
                end = mid - 1; // Try a smaller speed
            } else {
                start = mid + 1; // Try a larger speed
            }
        }
        return start; // Start will hold the minimum valid speed
    }

    // Helper function to find the maximum pile size
    public static int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
