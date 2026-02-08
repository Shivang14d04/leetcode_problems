class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for(int a : nums){
            long val = a;
            while(!stack.isEmpty() && stack.peek() == val){
                stack.pop();
                val = 2*val;
            }
            
            stack.push(val);
                
            
            
        }

        return new ArrayList<>(stack);
    }
}