class Solution {
    public int countCollisions(String directions) {
        int left = 0;
        int n = directions.length();
        int right = n - 1;
        int count = 0;
        while (left < n && directions.charAt(left) == 'L')
            left++;
        while (right >= 0 && directions.charAt(right) == 'R')
            right--;

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                count++;
            }
        }

        return count;

    }
}