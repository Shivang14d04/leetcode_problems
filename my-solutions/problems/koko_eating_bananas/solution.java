class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = getMaxPile(piles); // Max pile size as the upper bound
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (canEatInTime(piles, mid, h)) {
                end = mid - 1; // Try a smaller speed
            } else {
                start = mid + 1; // Try a larger speed
            }
        }
        return start;  
    }

    // Helper method to check if Koko can finish within h hours at speed k
    public static boolean canEatInTime(int[] piles, int k, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // Ceiling division
            if (hours > h) { // Exit early if hours exceed h
                return false;
            }
        }
        return true;
    }

    // Helper method to find the maximum pile size
    private int getMaxPile(int[] piles) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }
}
