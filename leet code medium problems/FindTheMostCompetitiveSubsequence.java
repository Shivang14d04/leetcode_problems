import java.util.Stack;
class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack1 = new Stack<>();

        for(int i = 0 ; i< nums.length;i++){
            int a = nums[i];
            
            while(!stack1.isEmpty() && stack1.peek()>a && stack1.size() + nums.length - i > k){
               
                stack1.pop();
                
            }
            stack1.push(a);
        }
        if(stack1.size()>k){
            while(stack1.size()!=k){
                stack1.pop();
            }
        }
        int [] result = new int[stack1.size()];
        for(int i = stack1.size()-1 ; i>=0;i--){
            result[i] = stack1.get(i);
        }
        return result;
        
    }
}