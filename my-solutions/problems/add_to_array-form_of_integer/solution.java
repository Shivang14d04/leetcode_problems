import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        
        int n = num.length;
        int carry = 0;
        
        // Process the array from the end
        for (int i = n - 1; i >= 0 || k > 0 || carry > 0; i--) {
            int currentDigit = (i >= 0) ? num[i] : 0; // Get the current digit from num or 0 if out of bounds
            int sum = currentDigit + (k % 10) + carry; // Add the current digit, the last digit of k, and carry
            result.add(sum % 10); // Add the last digit of the sum to the result
            carry = sum / 10; // Calculate the new carry
            k /= 10; // Remove the last digit of k
        }
        
        // Reverse the result list to get the correct order
        Collections.reverse(result);
        
        return result;
    }
}
