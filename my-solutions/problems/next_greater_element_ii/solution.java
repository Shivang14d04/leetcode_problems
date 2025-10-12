class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int currEle = arr[i];

            for (int j = 1; j < n; j++) {
                int ind = (i + j) % n;

                if (arr[ind] > currEle) {
                    ans[i] = arr[ind];
                    break;
                }
            }
        }

        return ans;
    
    }
}