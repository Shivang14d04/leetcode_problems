class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int stone: asteroids){
            if(stone>0){
                stack.push(stone);
            }
            else{
                while(!stack.isEmpty() && stack.peek() >0 &&  stack.peek() < -stone){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() <0) stack.push(stone);
                if(stack.peek()== -stone) stack.pop();
            }
        }

        int [] ans = new int[stack.size()];
        int i = stack.size()-1;
        while(!stack.isEmpty() && i >=0){
            ans[i--] = stack.pop();
        
        }
        return ans;
    }
}