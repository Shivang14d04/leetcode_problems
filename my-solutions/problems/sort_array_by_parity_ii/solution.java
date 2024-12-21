class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int evenIndex = 0; // Pointer for even indices
        int oddIndex = 1;  // Pointer for odd indices
        int[] answer = new int[n];
        
        for (int num : nums) {
            if (num % 2 == 0) { // If the number is even
                answer[evenIndex] = num;
                evenIndex += 2;
            } else { // If the number is odd
                answer[oddIndex] = num;
                oddIndex += 2;
            }
        }
        
        return answer;
    }
}
