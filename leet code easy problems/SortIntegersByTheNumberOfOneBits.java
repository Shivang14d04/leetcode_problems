import java.util.*;

public class SortIntegersByTheNumberOfOneBits {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] sortedArr = sortByBits(arr);
        System.out.println(Arrays.toString(sortedArr)); 
    }

    public static int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[] for sorting with a custom comparator
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
