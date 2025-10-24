class Solution {
    public int[] findNSE(int[] arr){
        int n = arr.length;
        int [] ans = new int[n];
        Stack<Integer> stack  = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek():n;
            stack.push(i);
        }
        return ans;

    }
        public int[] findPSE(int[] arr){
        int n = arr.length;
        int [] ans = new int[n];
        Stack<Integer> stack  = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]> arr[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek():-1;
            stack.push(i);
        }
        return ans;

    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int [] nse = findNSE(arr);
        int [] pse = findPSE(arr);
        int mod = (int)1e9 + 7;
        int sum = 0;
        for(int i = 0;i<n;i++){
            int left = i - pse[i];
            int right = nse[i] - i;

            long freq  = left*right*1L;
            int val = (int)((freq*arr[i])%mod);

            sum = (sum + val)%mod;

        }
        return sum;
    }
}