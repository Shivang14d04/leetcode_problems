class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];  // Calculate initial difference
        
        for (int i = 2; i < arr.length; i++) {  // Start loop from the third element
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
