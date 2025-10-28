class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);

    }
    public int[] findNSE(int [] nums){
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() :n;
            stack.push(i);
        }
        return ans;
    }
    public int[] findNGE(int [] nums){
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() :n;
            stack.push(i);
        }
        return ans;
    } 
    public int[] findPSE(int [] nums){
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() :-1;
            stack.push(i);
        }
        return ans;
    }

    public int[] findPGE(int [] nums){
        int n = nums.length;
        int [] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }
            ans[i] = !stack.isEmpty() ? stack.peek() :-1;
            stack.push(i);
        }
        return ans;
    } 
public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSE(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }
    private long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pgee = findPGE(arr);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;
            long freq = 1L * left * right;
            sum += freq * arr[i];
        }
        return sum;
    }    

}