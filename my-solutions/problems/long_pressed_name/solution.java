class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;

        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;  // Move both pointers if characters match
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Long-pressed character, move only typed pointer
                j++;
            } else {
                return false; // Invalid character found
            }
            
        }

        // Ensure all characters in `name` were matched
        return i == name.length();
    }
}
