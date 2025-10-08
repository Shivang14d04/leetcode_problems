class MinStack {
    Stack<Integer> stack ;
    Stack<Integer> stack2;
  

    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(stack2.isEmpty() || val <= stack2.peek()){
            stack2.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int popped = stack.pop();
           if (popped == stack2.peek()){
             stack2.pop();
           }
           
        }

    }
    
    public int top() {
        
return stack.isEmpty()? -1: stack.peek();
        
    }
    
    public int getMin() {
        
        return stack2.isEmpty()? -1: stack2.peek();
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */