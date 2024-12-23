class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Sort the array with a custom comparator
        Arrays.sort(integerArr, (a, b) -> {
            int bitCountA = Integer.bitCount(a); // Count 1's in binary representation of a
            int bitCountB = Integer.bitCount(b); // Count 1's in binary representation of b
            // First sort by the number of 1 bits, then by natural order
            if (bitCountA == bitCountB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(bitCountA, bitCountB);
        });

        // Convert Integer[] back to int[] and return
        return Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();
}
}